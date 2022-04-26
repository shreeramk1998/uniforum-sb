package com.uniforum.alpha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniforum.alpha.constant.QueryConstants.CommentQueryConstants;
import com.uniforum.alpha.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	/**
	 * fetches comment by postnum.<br>
	 * 
	 * @param postNum
	 * @return
	 */
	@Query(value = CommentQueryConstants.FIND_ALL_POST_COMMENT)
	public List<Comment> findAllByPostNum(@Param("postNum") Long postNum);

	/**
	 * fetches replies of a particular comment .<br>
	 * 
	 * @param postNum
	 * @return
	 */
	@Query(value = CommentQueryConstants.FIND_ALL_COMMENT_REPLIES)
	public List<Comment> findAllByParentNum(@Param("commentNum") Long commentNum);
}
