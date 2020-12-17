package tlu.controller.api;

import java.io.IOException;
import java.text.DateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;

import tlu.model.ChuongTrinhDaoTao;
import tlu.payload.ChuongTrinhDaoTaoRequest;
import tlu.repository.ChuongTrinhDaoTaoRepository;
import tlu.service.PdfExportService;

@Controller
public class ReportController {

	@Autowired
	private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

	
	@GetMapping("/gg")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=sss.pdf";
        response.setHeader(headerKey, headerValue);
        
		ChuongTrinhDaoTao ctdt = chuongTrinhDaoTaoRepository.findByMaNamHocAndMaNganhHoc(
				"18",
				"QE"
		);
		 
        PdfExportService exporter = new PdfExportService(ctdt);
        exporter.export(response);
	}
	
}
