package com.uniforum.alpha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniforum.alpha.entity.Comment;
import com.uniforum.alpha.entity.Post;
import com.uniforum.alpha.repository.CommentRepository;
import com.uniforum.alpha.repository.PostRepository;
import com.uniforum.alpha.service.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Post savePost(Post post) {

		return postRepository.save(post);
	}

	@Override
	public List<Post> getPosts() {

		return postRepository.findAll();
	}

	@Override
	public List<Comment> getComments(Long postNum) {

		return commentRepository.findAllByPostNum(postNum);
	}

	@Override
	public Comment saveComment(Comment comment) {

		return commentRepository.save(comment);
	}
	
	@Override
	public List<Comment> findCommentReplies(Long commentNum) {

		return commentRepository.findAllByParentNum(commentNum);
	}

	@Override
	public List<Post> getUserPosts(Long userNum) {
		System.err.println(postRepository.findAllByUserNum(userNum));
		return postRepository.findAllByUserNum(userNum);
	}
}