package com.uniforum.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniforum.alpha.constant.AppConstants;
import com.uniforum.alpha.constant.AppConstants.PostApiConstants;
import com.uniforum.alpha.entity.Comment;
import com.uniforum.alpha.entity.Post;
import com.uniforum.alpha.entity.UserPostXref;
import com.uniforum.alpha.service.IPostService;

@RestController
@RequestMapping(AppConstants.BASE_API + PostApiConstants.POST_CONTROLLER_BASE)
public class PostController {

	@Autowired
	private IPostService postService;

	@GetMapping(path = PostApiConstants.GET_POSTS, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> getPosts() {
		return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
	}

	@GetMapping(path = PostApiConstants.GET_USER_POSTS, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> getUserPosts(@PathVariable("userNum") Long userNum) {
		return new ResponseEntity<List<Post>>(postService.getUserPosts(userNum), HttpStatus.OK);
	}
	
	@PostMapping(path = PostApiConstants.SAVE_POSTS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> savePost(@RequestBody Post post) {

		return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.CREATED);
	}

	@GetMapping(path = PostApiConstants.GET_POST_COMMENT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> getComments(@PathVariable("postNum") Long postNum) {

		return new ResponseEntity<List<Comment>>(postService.getComments(postNum), HttpStatus.OK);
	}

	@PostMapping(path = PostApiConstants.SAVE_POST_COMMENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {

		return new ResponseEntity<Comment>(postService.saveComment(comment), HttpStatus.CREATED);
	}

	@PostMapping(path = PostApiConstants.UPVOTE_POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> upvotePost(@RequestBody UserPostXref userPostXref) {

		return new ResponseEntity<Post>(postService.upvotePost(userPostXref), HttpStatus.OK);
	}

}
