package tlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tlu.model.DeCuongChiTiet;
import tlu.model.MonHoc;

public interface DeCuongChiTietRepository extends JpaRepository<DeCuongChiTiet, Long> {

		List<DeCuongChiTiet> findByMonHoc(MonHoc monHoc);
}
