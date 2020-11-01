package tlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tlu.model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, String> {

	@Query(value = "select * from "
			+ "mon_hoc mh where ma_mon NOT IN "
			+ "	(select mon_hoc_ma_mon "
			+ "		from hoc_phan_thuoc_chuong_trinh_dao_tao where chuong_trinh_dao_tao_ma_chuong_trinh_dao_tao = ?1)",
			nativeQuery = true)
	public List<MonHoc> getListMonHocByCTDD(String maChuongTrinhDaoTao);
	
}
