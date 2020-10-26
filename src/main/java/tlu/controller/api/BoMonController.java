package tlu.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.model.BoMon;
import tlu.model.GiaoVien;
import tlu.payload.BoMonRequest;
import tlu.repository.BoMonRepository;
import tlu.repository.GiaoVienRepository;

@RestController
@RequestMapping(path = "api/v1/bo-mon", produces = "application/json;charset=UTF-8")
public class BoMonController {

	@Autowired
	private BoMonRepository boMonRepository;
	
	@Autowired 
	GiaoVienRepository giaoVienRepository;
	
	@GetMapping()
	public ResponseEntity<List<BoMon>> getAll() {
		List<BoMon> all = boMonRepository.findAll();
		return new ResponseEntity<List<BoMon>>(all, HttpStatus.OK);
	}
	
	@PostMapping()
	public void createBoMon(@RequestBody BoMonRequest boMonRequest) {
		BoMon bMon = new BoMon();
		bMon.setMaBoMon(boMonRequest.getMaBoMon());
		bMon.setTenBoMon(boMonRequest.getTenBoMon());
		Optional<GiaoVien> giaoVien = giaoVienRepository.findById(boMonRequest.getTruongBoMon());
		if (giaoVien.isPresent()) {
			bMon.setTruongBoMon(giaoVien.get());
		}
		
		boMonRepository.save(bMon);
	}
	
	@PutMapping
	void editTruongBoMon(@RequestBody BoMonRequest boMonRequest) {
		GiaoVien giaoVien = giaoVienRepository.findById(boMonRequest.getTruongBoMon()).get();
		BoMon bMon = boMonRepository.findById(boMonRequest.getMaBoMon()).get();
		bMon.setTruongBoMon(giaoVien);
		boMonRepository.save(bMon);
	}
	
	@GetMapping("/{maBoMon}")
	public ResponseEntity<BoMon> getBoMon(@PathVariable String maBoMon) {
		return new ResponseEntity<BoMon>(boMonRepository.findById(maBoMon).get(), HttpStatus.OK);
	}
	
}
