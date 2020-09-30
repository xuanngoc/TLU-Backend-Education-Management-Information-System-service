package tlu.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tlu.model.MonHoc;

public class FileService {
	
	public static List<MonHoc> readMonHocFromFile(InputStream fileInputStream) throws IOException {
		List<MonHoc> monHocList = new ArrayList<MonHoc>();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheetAt(0);
			
			for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
		        MonHoc mh = new MonHoc();
		            
		        XSSFRow row = worksheet.getRow(i);
		            
		        mh.setMaMon(row.getCell(0).getStringCellValue());
		        mh.setTenMon(row.getCell(1).getStringCellValue());
		        mh.setSoTinChi(Integer.parseInt(row.getCell(2).getStringCellValue()));
		       // mh.setHocPhanTienQuyet(Arrays.asList(row.getCell(3).getStringCellValue().split(",")));
		        mh.setSoGio((int) row.getCell(4).getNumericCellValue());
		        mh.setHeSo(row.getCell(5).getNumericCellValue());
		        monHocList.add(mh);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return monHocList;
	}
}
