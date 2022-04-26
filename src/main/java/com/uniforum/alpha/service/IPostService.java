package com.uniforum.alpha.service;

import java.util.List;

import com.uniforum.alpha.entity.Comment;
import com.uniforum.alpha.entity.Post;

public interface IPostService {
	
	public Post savePost(Post post);

	public List<Post> getPosts();

	public List<Comment> getComments(Long postNum);

	public Comment saveComment(Comment comment);

	public List<Comment> findCommentReplies(Long commentNum);

	public List<Post> getUserPosts(Long userNum);

}