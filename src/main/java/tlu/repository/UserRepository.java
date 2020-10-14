package tlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tlu.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
