package com.uniforum.alpha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniforum.alpha.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findById(String id);
	
}
