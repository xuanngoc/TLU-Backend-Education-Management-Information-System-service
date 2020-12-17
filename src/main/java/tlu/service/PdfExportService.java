package tlu.service;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import tlu.model.ChuongTrinhDaoTao;
import tlu.model.MonHoc;

public class PdfExportService {
	
	private ChuongTrinhDaoTao chuongTrinhDaoTao;
	
	public PdfExportService(ChuongTrinhDaoTao chuongTrinhDaoTao) {
		this.chuongTrinhDaoTao = chuongTrinhDaoTao;
	}

	public Document export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A3 );
        response.addHeader("Content-Type",  "charset=utf-8");
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, "utf-8");
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Khung chương trình đào tạo  " + chuongTrinhDaoTao.getNganhHoc().getTenNganhHoc() , font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        Paragraph year = new Paragraph(chuongTrinhDaoTao.getNamHoc().getTenNamHoc() , font);
        year.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        document.add(year);
         document.add(new Paragraph(""));
         document.add(new Paragraph("1. Giáo dục đại cương"));
        PdfPTable tableDaiCuong = new PdfPTable(6);
        tableDaiCuong.setWidthPercentage(100f);
        tableDaiCuong.setWidths(new float[] {1.5f, 5.5f, 1.0f, 3.0f, 1f, 1f});
        tableDaiCuong.setSpacingBefore(10);
         
        writeTableHeader(tableDaiCuong);
        writeTableDataDC(tableDaiCuong);
         
        document.add(tableDaiCuong);
         
        document.add(new Paragraph(""));
        document.add(new Paragraph("2. Giáo dục chuyên ngành"));
        PdfPTable tableCN = new PdfPTable(6);
        tableCN.setWidthPercentage(100f);
        tableCN.setWidths(new float[] {1.5f, 5.5f, 1.0f, 3.0f, 1f, 1f});
        tableCN.setSpacingBefore(10);
         
        writeTableHeader(tableCN);
        writeTableDataCN(tableCN);
         
        document.add(tableCN);
        
        document.add(new Paragraph(""));
        document.add(new Paragraph("3. Giáo dục tự do"));
        PdfPTable tableTD = new PdfPTable(6);
        tableTD.setWidthPercentage(100f);
        tableTD.setWidths(new float[] {1.5f, 5.5f, 1.0f, 3.0f, 1f, 1f});
        tableTD.setSpacingBefore(10);
         
        writeTableHeader(tableTD);
        writeTableDataTD(tableTD);
         
        document.add(tableTD);
        
        
        document.close();
         return document;
    }
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		//cell.setBackgroundColor(Color.BLACK);
		cell.setPadding(5);
		
		cell.setPhrase(new Phrase("Mã học phần"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Tên học phần"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Số tín chỉ"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Điều kiện tiên quyết"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Số giờ"));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Hệ số"));
		table.addCell(cell);	
	}
	
	private void writeTableDataDC(PdfPTable table) {
		chuongTrinhDaoTao.getHocChuongTrinhDaoTao().forEach(ct -> {
			if (ct.getLoaiChuongTrinh().equals( "DAI_CUONG"))s	 {
				MonHoc mHoc = ct.getMonHoc();
				table.addCell(mHoc.getMaMon());
				table.addCell(mHoc.getTenMon());
				table.addCell(String.valueOf(mHoc.getSoTinChi()));
				table.addCell(mHoc.getHocPhanTienQuyet());
				table.addCell(String.valueOf(mHoc.getSoGio()));
				table.addCell(String.valueOf(mHoc.getHeSo()));
			}
		});
	}
	
	private void writeTableDataCN(PdfPTable table) {
		chuongTrinhDaoTao.getHocChuongTrinhDaoTao().forEach(ct -> {
			if (ct.getLoaiChuongTrinh().equals( "CHUYEN_NGANH")) {
				MonHoc mHoc = ct.getMonHoc();
				table.addCell(mHoc.getMaMon());
				table.addCell(mHoc.getTenMon());
				table.addCell(String.valueOf(mHoc.getSoTinChi()));
				table.addCell(mHoc.getHocPhanTienQuyet());
				table.addCell(String.valueOf(mHoc.getSoGio()));
				table.addCell(String.valueOf(mHoc.getHeSo()));
			}
		});
	}
	
	private void writeTableDataTD(PdfPTable table) {
		chuongTrinhDaoTao.getHocChuongTrinhDaoTao().forEach(ct -> {
			if (ct.getLoaiChuongTrinh().equals("TU_DO")) {
				MonHoc mHoc = ct.getMonHoc();
				table.addCell(mHoc.getMaMon());
				table.addCell(mHoc.getTenMon());
				table.addCell(String.valueOf(mHoc.getSoTinChi()));
				table.addCell(mHoc.getHocPhanTienQuyet());
				table.addCell(String.valueOf(mHoc.getSoGio()));
				table.addCell(String.valueOf(mHoc.getHeSo()));
			}
		});
	}
}
