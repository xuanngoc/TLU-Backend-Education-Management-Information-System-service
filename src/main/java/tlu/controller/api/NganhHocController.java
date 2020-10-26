package tlu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.model.BoMon;
import tlu.model.NganhHoc;
import tlu.payload.NganhHocRequest;
import tlu.repository.BoMonRepository;
import tlu.repository.NganhHocRepository;

@RestController
@RequestMapping("/api/v1/nganh-hoc")
public class NganhHocController {
	
	@Autowired
	private NganhHocRepository nganhHocRepository;
	
	@Autowired
	private BoMonRepository boMonRepository;
	
	@GetMapping
	public ResponseEntity<List<NganhHoc>> getAll() {
		List<NganhHoc> all = nganhHocRepository.findAll();
		return new ResponseEntity<List<NganhHoc>>(all, HttpStatus.OK);
	}
	
	@PostMapping
	public void create(@RequestBody NganhHocRequest nganhHoc) {
		BoMon boMon = boMonRepository.findById(nganhHoc.getMaBoMon()).get();
		NganhHoc nh = new NganhHoc(nganhHoc.getMaNganhHoc(), nganhHoc.getTenNganhHoc(), boMon);
		nganhHocRepository.save(nh);
	}
	
	@PutMapping
	public void edit(@RequestBody NganhHoc nganhHoc) {
		nganhHocRepository.save(nganhHoc);
	}
	
	
	
}
