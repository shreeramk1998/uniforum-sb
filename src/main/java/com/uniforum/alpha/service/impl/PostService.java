package com.uniforum.alpha.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniforum.alpha.entity.Comment;
import com.uniforum.alpha.entity.Post;
import com.uniforum.alpha.entity.UserPostXref;
import com.uniforum.alpha.repository.CommentRepository;
import com.uniforum.alpha.repository.PostRepository;
import com.uniforum.alpha.repository.UserPostXrefRepository;
import com.uniforum.alpha.service.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserPostXrefRepository userPostXrefRepository;

	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public Post savePost(Post post) {

		post = postRepository.save(post);
		em.refresh(post);
		return post;
	}

	@Override
	public List<Post> getPosts() {

		String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return postRepository.findAllPosts();
	}

	@Override
	public List<Comment> getComments(Long postNum) {

		List<Comment> commentList = commentRepository.findAllByPostNum(postNum);
		Map<Long, List<Comment>> commentRepliesMap = commentList.stream().filter(c -> c.getParentNum() != null)
				.collect(Collectors.groupingBy(Comment::getParentNum));
		for (Comment comment : commentList) {
			if (commentRepliesMap.containsKey(comment.getCommentNum())) {
				comment.setReplies(commentRepliesMap.get(comment.getCommentNum()));
			}
		}
		commentList.removeIf(c -> c.getParentNum() != null);
		return commentList;
	}

	@Override
	@Transactional
	public Comment saveComment(Comment comment) {

		comment = commentRepository.saveAndFlush(comment);
		em.refresh(comment);
		return comment;
	}

	@Override
	public List<Post> getUserPosts(Long userNum) {
		String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return postRepository.findAllByUserNum(userNum);
	}

	@Transactional
	@Override
	public Post upvotePost(UserPostXref userPostXref) {

		userPostXrefRepository.saveAndFlush(userPostXref);
		Post post = postRepository.findByPostNum(userPostXref.getPostNum());

		post.setUpvote(post.getUpvote() + (userPostXref.getUpvoteFlag() ? 1l : -1l));

		return postRepository.saveAndFlush(post);
	}
}