package com.uniforum.alpha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniforum.alpha.constant.QueryConstants.PostQueryConstants;
import com.uniforum.alpha.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query(value = PostQueryConstants.FIND_ALL_POST_BY_USER)
	public List<Post> findAllByUserNum(@Param("userNum") Long userNum);
	
}
