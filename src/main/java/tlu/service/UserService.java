package tlu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tlu.model.User;
import tlu.model.UserPrincipal;
import tlu.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user, passwordEncoder);
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	public UserPrincipal loadUserById(long id) {
		User user = userRepository.findById(id).orElseThrow(() -> 
			new UsernameNotFoundException("User not found with id:" + id)
		);
		return new UserPrincipal(user, passwordEncoder);
	}

	
}
