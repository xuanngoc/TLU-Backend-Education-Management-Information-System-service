package tlu.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tlu.model.HocPhanThuocChuongTrinhDaoTao;
import tlu.model.HocPhanThuocChuongTrinhDaoTaoID;

public interface HocPhanThuocChuongTrinhDaoTaoReposiroty  
				extends JpaRepository<HocPhanThuocChuongTrinhDaoTao, HocPhanThuocChuongTrinhDaoTaoID> {


}

