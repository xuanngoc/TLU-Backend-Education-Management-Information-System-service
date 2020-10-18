package tlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tlu.model.BoMon;

public interface BoMonRepository extends JpaRepository<BoMon, String> {
	
}
