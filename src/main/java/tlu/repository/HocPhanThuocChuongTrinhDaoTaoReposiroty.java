package tlu.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tlu.model.HocPhanThuocChuongTrinhDaoTao;
import tlu.model.HocPhanThuocChuongTrinhDaoTaoID;
import tlu.model.MonHoc;

public interface HocPhanThuocChuongTrinhDaoTaoReposiroty  
				extends JpaRepository<HocPhanThuocChuongTrinhDaoTao, Long> {

	@Query(value = "select mon_hoc_ma_mon from "
			+ "hoc_phan_thuoc_chuong_trinh_dao_tao where "
			+ "chuong_trinh_dao_tao_ma_chuong_trinh_dao_tao = ?1", nativeQuery = true)
	public List<MonHoc> getMonHocs(String maChuongTrinh);
}

