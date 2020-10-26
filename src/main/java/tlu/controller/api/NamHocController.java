package tlu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.model.NamHoc;
import tlu.repository.NamHocRepository;


@RestController
@RequestMapping("api/v1/nam-hoc")
public class NamHocController {
	
	@Autowired
	private NamHocRepository namHocRepository;
	
	@GetMapping
	public ResponseEntity<List<NamHoc>> getAll() {
		List<NamHoc> namHocs = namHocRepository.findAll();
		return new ResponseEntity<List<NamHoc>>(namHocs, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody String tenNamHoc) {
		NamHoc namHoc = new NamHoc();
		namHoc.setTenNamHoc(tenNamHoc);
		
		namHocRepository.save(namHoc);
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	
	
	
	
}
