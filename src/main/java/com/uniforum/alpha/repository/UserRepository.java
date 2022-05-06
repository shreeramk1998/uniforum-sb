package com.uniforum.alpha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniforum.alpha.constant.QueryConstants.UserQueryConstants;
import com.uniforum.alpha.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findById(String id);
	
	@Modifying
	@Query(value = UserQueryConstants.UPDATE_USER_SIGNATURE)
	public void updateSignature(@Param("signature")String signature, @Param("id") String id);
	
}
