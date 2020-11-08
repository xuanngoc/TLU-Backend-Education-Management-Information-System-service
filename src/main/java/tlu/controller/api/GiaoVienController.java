package tlu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tlu.config.ApplicationRole;
import tlu.model.BoMon;
import tlu.model.GiaoVien;
import tlu.model.User;
import tlu.payload.GiaoVienRequest;
import tlu.repository.BoMonRepository;
import tlu.repository.GiaoVienRepository;
import tlu.repository.UserRepository;


@RestController
@RequestMapping("api/v1/giao-vien")
public class GiaoVienController {

	@Autowired
	private GiaoVienRepository giaoVienRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoMonRepository boMonRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping()
	public ResponseEntity<List<GiaoVien>> getAll() {
		List<GiaoVien> allGiaoViens = giaoVienRepository.findAll();
		return new ResponseEntity<List<GiaoVien>>(allGiaoViens, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Object> createGiaoVien(@RequestBody GiaoVienRequest giaoVienRequest) {
		
		User user = new User(
				giaoVienRequest.getUsername(), 
				passwordEncoder.encode(giaoVienRequest.getPassword()),
				giaoVienRequest.getFullname(), 
				giaoVienRequest.getEmail(), 
				giaoVienRequest.getPhone(),
				ApplicationRole.GIAOVIEN.name(),
				false);
		user = userRepository.save(user);
		
		BoMon boMon = boMonRepository.findById(giaoVienRequest.getMaBoMon()).get();
		GiaoVien gVien = new GiaoVien();
		gVien.setUser(user);
		gVien.setMaGiaoVien(giaoVienRequest.getMaGiaoVien());
		gVien.setThuocBoMon(boMon);
		giaoVienRepository.save(gVien);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/ma-bo-mon")
	public ResponseEntity<String> getMaBoMon(@RequestParam String userId) {
		String maBoMon =  giaoVienRepository.getMaBoMon(userId);
		return new ResponseEntity<String>(maBoMon, HttpStatus.OK);
	}
	
}
