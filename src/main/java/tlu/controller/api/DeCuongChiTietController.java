package tlu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.model.DeCuongChiTiet;
import tlu.model.MonHoc;
import tlu.repository.DeCuongChiTietRepository;
import tlu.repository.MonHocRepository;
import tlu.repository.TaiLieuRepository;

@RestController
@RequestMapping("api/v1/de-cuong-chi-tiet")
public class DeCuongChiTietController {

	@Autowired
	private DeCuongChiTietRepository deCuongChiTietRepository;
	
	@Autowired
	private TaiLieuRepository taiLieuRepository;
	
	@Autowired
	private MonHocRepository monHocRepository;
	
	@GetMapping("/{maMonHoc}")
	public ResponseEntity<List<DeCuongChiTiet>> getSubjectOutlineBySubjectId(@PathVariable String maMonHoc) {
		MonHoc mHoc = monHocRepository.findById(maMonHoc).get();
		List<DeCuongChiTiet> deCuongChiTiets = deCuongChiTietRepository.findByMonHoc(mHoc);
		return new ResponseEntity<List<DeCuongChiTiet>>(deCuongChiTiets, HttpStatus.OK);
	}
	
	
	
}
