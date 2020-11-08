package tlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tlu.model.GiaoVien;

public interface GiaoVienRepository extends JpaRepository<GiaoVien, String> {

	@Query(value = "select bm.ma_bo_mon from bo_mon bm "
			+ " inner join (select gv.* from giao_vien gv where user_id=?1  ) gv1 on bm.ma_bo_mon = gv1.ma_bo_mon ", nativeQuery = true)
	public String getMaBoMon(String userId);
	
}
