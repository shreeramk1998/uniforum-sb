package com.uniforum.alpha.service;

import java.util.List;

import com.uniforum.alpha.entity.Post;

public interface IPostService {
	     public Post savePost(Post post);
	     
	     public List<Post> getPots();
	     
}