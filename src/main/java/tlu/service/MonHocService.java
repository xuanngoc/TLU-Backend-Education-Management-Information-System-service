package tlu.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlu.model.MonHoc;
import tlu.repository.BoMonRepository;
import tlu.repository.MonHocRepository;

@Service
public class MonHocService {
	
	@Autowired
	private MonHocRepository monHocRepository;
	
	@Autowired
	private BoMonRepository boMonRepository;
	
	public List<MonHoc> getAll() {
		return monHocRepository.findAll();
	}
	
	public List<MonHoc> getAll1(String maChuongTrinhDaoTao) {
		return monHocRepository.getListMonHocByCTDD(maChuongTrinhDaoTao);
	}
	
	public void readMonHocFromFile(InputStream fileInputStream) {
		try {
			FileService.readMonHocFromFile(fileInputStream, boMonRepository.findAll()).forEach(monHoc -> {
				monHocRepository.save(monHoc);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<MonHoc> getMonHocBelongTo(String maBoMon) {
		
		return monHocRepository.findByBoMon(boMonRepository.findById(maBoMon).get());
	}
}
