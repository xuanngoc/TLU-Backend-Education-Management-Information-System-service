package tlu.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.jwt.JwtTokenProvider;
import tlu.model.User;
import tlu.model.UserPrincipal;
import tlu.payload.LoginRequest;
import tlu.payload.LoginResponse;
import tlu.service.UserService;

@RestController
@RequestMapping("api/v1")
public class HomeController {

	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private UserService userService;
    
	@PostMapping(path = "/login", produces = "application/json")
	public ResponseEntity<LoginResponse> authenticationUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication =  authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken((UserPrincipal) authentication.getPrincipal());
		return new ResponseEntity<LoginResponse>(new LoginResponse(jwt), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> getUserInfo(Authentication authentication) {
		String username = authentication.getName();
		User user = userService.findUserByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
}
