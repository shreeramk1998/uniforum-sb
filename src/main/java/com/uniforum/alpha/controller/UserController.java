package com.uniforum.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniforum.alpha.constant.AppConstants;
import com.uniforum.alpha.constant.AppConstants.UserApiConstants;
import com.uniforum.alpha.entity.User;
import com.uniforum.alpha.service.UserService;

@RestController
@RequestMapping(AppConstants.BASE_API + UserApiConstants.USER_CONTROLLER_BASE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = UserApiConstants.SAVE_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> savePost(@RequestBody User user) {

		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@PostMapping(path = UserApiConstants.UPDATE_USER_SIGNATURE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateSignture(@RequestBody User user) {

		userService.updateSignature(user.getSignature());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
