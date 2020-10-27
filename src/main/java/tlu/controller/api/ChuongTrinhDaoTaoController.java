package tlu.controller.api;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tlu.model.ChuongTrinhDaoTao;
import tlu.payload.ChuongTrinhDaoTaoRequest;
import tlu.repository.ChuongTrinhDaoTaoRepository;
import tlu.repository.HocPhanThuocChuongTrinhDaoTaoReposiroty;

@RestController
@RequestMapping("api/v1/chuong-trinh-dao-tao")
public class ChuongTrinhDaoTaoController {

	@Autowired
	private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

	@Autowired 
	private HocPhanThuocChuongTrinhDaoTaoReposiroty hocPhanThuocChuongTrinhDaoTaoReposiroty;
	
	
	@PostMapping
	public ResponseEntity<ChuongTrinhDaoTao> getChuongTrinhDaoTao(@RequestBody ChuongTrinhDaoTaoRequest ctdtRequest) {
		
		ChuongTrinhDaoTao ctdt = chuongTrinhDaoTaoRepository.findByMaNamHocAndMaNganhHoc(
				ctdtRequest.getMaNamHoc(),
				ctdtRequest.getMaNganhHoc()
		);
		
		return new ResponseEntity<ChuongTrinhDaoTao>(ctdt, HttpStatus.OK);
	}
	
}
