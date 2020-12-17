package tlu.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlu.config.EducationProgramType;
import tlu.model.ChuongTrinhDaoTao;
import tlu.model.HocPhanThuocChuongTrinhDaoTao;
import tlu.model.HocPhanThuocChuongTrinhDaoTaoID;
import tlu.model.MonHoc;
import tlu.payload.ChuongTrinhDaoTaoRequest;
import tlu.payload.MonHocRequest;
import tlu.repository.ChuongTrinhDaoTaoRepository;
import tlu.repository.HocPhanThuocChuongTrinhDaoTaoReposiroty;
import tlu.repository.MonHocRepository;

@RestController
@RequestMapping("api/v1/chuong-trinh-dao-tao")
public class ChuongTrinhDaoTaoController {

	@Autowired
	private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

	@Autowired 
	private HocPhanThuocChuongTrinhDaoTaoReposiroty hocPhanThuocChuongTrinhDaoTaoReposiroty;
	
	@Autowired
	private MonHocRepository monHocRepository;
	
	@PostMapping
	public ResponseEntity<ChuongTrinhDaoTao> getChuongTrinhDaoTao(@RequestBody ChuongTrinhDaoTaoRequest ctdtRequest) {
		
		ChuongTrinhDaoTao ctdt = chuongTrinhDaoTaoRepository.findByMaNamHocAndMaNganhHoc(
				ctdtRequest.getMaNamHoc(),
				ctdtRequest.getMaNganhHoc()
		);
		
		return new ResponseEntity<ChuongTrinhDaoTao>(ctdt, HttpStatus.OK);
	}
	
	@PostMapping("/{loaiChuongTrinh}/{maChuongTrinh}")
	public void add(@PathVariable String loaiChuongTrinh, 
				@PathVariable long maChuongTrinh,
				@RequestBody MonHocRequest maMonHoc) {
		ChuongTrinhDaoTao chuongTrinhDaoTao = chuongTrinhDaoTaoRepository.findById(maChuongTrinh).get();
		MonHoc monHoc = monHocRepository.findById(maMonHoc.getMaMon()).get();
		
		HocPhanThuocChuongTrinhDaoTao hptctdTao = new HocPhanThuocChuongTrinhDaoTao();
		hptctdTao.setChuongTrinhDaoTao(chuongTrinhDaoTao);
		hptctdTao.setMonHoc(monHoc);
		
		String educationProgramType = "";
		switch (loaiChuongTrinh) {
			case  "dai-cuong":
				educationProgramType = EducationProgramType.DAI_CUONG.name();
				break;
			case "chuyen-nganh":
				educationProgramType = EducationProgramType.CHUYEN_NGANH.name();
				break;
			case "tu-do":
				educationProgramType = EducationProgramType.TU_DO.name();
				break;
			default:
				break;
		}	
		hptctdTao.setId(1L);
		hptctdTao.setLoaiChuongTrinh(educationProgramType);
		hocPhanThuocChuongTrinhDaoTaoReposiroty.save(hptctdTao);
	}	
	
	@DeleteMapping("/remove/{id}")
	public void remove(@PathVariable long id ) {
		hocPhanThuocChuongTrinhDaoTaoReposiroty.deleteById(id);
	}
	
}
