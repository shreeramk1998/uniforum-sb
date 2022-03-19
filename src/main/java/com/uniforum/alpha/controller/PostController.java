package com.uniforum.alpha.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uniforum.alpha.entity.Post;
import com.uniforum.alpha.service.IPostService;

@RestController("/")
public class PostController {
//
//	@Autowired
//	private IPostService postService;
//
//	@GetMapping(path = "getPosts", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Post>> getPosts(){
//		return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
//	}
//	
//	@PostMapping(path = "savePost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Post> savePost(@RequestBody Post post){
//		
//		return new ResponseEntity<Post>(postService.savePost(post),HttpStatus.CREATED);
//	}
//	
}



