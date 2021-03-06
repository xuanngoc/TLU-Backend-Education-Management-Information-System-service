package tlu.controller.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tlu.model.MonHoc;
import tlu.service.MonHocService;

@RestController
@RequestMapping(path = "api/v1/mon-hoc")
public class MonHocController {

	@Autowired
	private MonHocService monHocService;
	
	//@CrossOrigin("http://localhost:3000")
	@GetMapping("")
	public ResponseEntity<List<MonHoc>> getMonHoc() {
		return new ResponseEntity<List<MonHoc>>(monHocService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("ma-mon/{maMon}")
	public ResponseEntity<MonHoc> getMonHocById(@PathVariable String maMon) {
		return new ResponseEntity<MonHoc>(monHocService.getById(maMon), HttpStatus.OK);
	} 
	
	@GetMapping("/{maChuongTrinhDaoTao}")
	public ResponseEntity<List<MonHoc>> getMonHoc1(@PathVariable String maChuongTrinhDaoTao) {
		return new ResponseEntity<List<MonHoc>>(monHocService.getAll1(maChuongTrinhDaoTao), HttpStatus.OK);
	}
	
	@GetMapping("/bo-mon/{maBoMon}")
	public ResponseEntity<List<MonHoc>> getMonHocs(@PathVariable String maBoMon) {
		return new ResponseEntity<List<MonHoc>>(monHocService.getMonHocBelongTo(maBoMon), HttpStatus.OK);
	}
	
	@PostMapping("/import")
	public void mapReadExcelDataToDB(@RequestParam MultipartFile file) throws IOException {
		monHocService.readMonHocFromFile(file.getInputStream());
	}
	
	
}
