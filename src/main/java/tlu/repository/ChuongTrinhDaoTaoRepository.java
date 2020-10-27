package tlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tlu.model.ChuongTrinhDaoTao;

public interface ChuongTrinhDaoTaoRepository extends JpaRepository<ChuongTrinhDaoTao, Long> {

	@Query(value = "SELECT * FROM chuong_trinh_dao_tao WHERE nam_hoc_ma_nam_hoc=?1 AND nganh_hoc_ma_nganh_hoc=?2", nativeQuery = true)
	public ChuongTrinhDaoTao findByMaNamHocAndMaNganhHoc(String maNamHoc, String maNganhHoc);
	
	
}
