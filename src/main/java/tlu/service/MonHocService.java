package tlu.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlu.model.MonHoc;
import tlu.repository.MonHocRepository;

@Service
public class MonHocService {
	
	@Autowired
	private MonHocRepository monHocRepository;
	
	public List<MonHoc> getAll() {
		return monHocRepository.findAll();
	}
	
	public List<MonHoc> getAll1(String maChuongTrinhDaoTao) {
		return monHocRepository.getListMonHocByCTDD(maChuongTrinhDaoTao);
	}
	
	public void readMonHocFromFile(InputStream fileInputStream) {
		try {
			FileService.readMonHocFromFile(fileInputStream).forEach(monHoc -> {
				monHocRepository.save(monHoc);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
