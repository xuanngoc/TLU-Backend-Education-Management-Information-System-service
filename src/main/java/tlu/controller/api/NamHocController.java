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

import tlu.model.ChuongTrinhDaoTao;
import tlu.model.NamHoc;
import tlu.model.NganhHoc;
import tlu.repository.ChuongTrinhDaoTaoRepository;
import tlu.repository.NamHocRepository;
import tlu.repository.NganhHocRepository;


@RestController
@RequestMapping("api/v1/nam-hoc")
public class NamHocController {
	
	@Autowired
	private NamHocRepository namHocRepository;
	
	@Autowired
	private NganhHocRepository nganhHocRepository;
	
	@Autowired
	private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;
	
	@GetMapping
	public ResponseEntity<List<NamHoc>> getAll() {
		List<NamHoc> namHocs = namHocRepository.findAll();
		return new ResponseEntity<List<NamHoc>>(namHocs, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody NamHoc namHoc) {
		
		NamHoc nh = namHocRepository.save(namHoc);
		// When a new School Year was created, Education Program will be generate automatically for  each Major;
		List<NganhHoc> nganhHocs = nganhHocRepository.findAll();
		nganhHocs.forEach((nganhHoc ) -> 
			saveChuongTrinhDaoTao(nh, nganhHoc)
		);
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	private void saveChuongTrinhDaoTao(NamHoc namHoc, NganhHoc nganhHoc) {
		ChuongTrinhDaoTao chuongTrinhDaoTao = new ChuongTrinhDaoTao(nganhHoc, namHoc);
		chuongTrinhDaoTaoRepository.save(chuongTrinhDaoTao);
	}
	
	
	
	
}
