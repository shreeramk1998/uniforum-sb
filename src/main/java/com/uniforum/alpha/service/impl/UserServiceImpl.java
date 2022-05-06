package com.uniforum.alpha.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.uniforum.alpha.entity.User;
import com.uniforum.alpha.repository.UserRepository;
import com.uniforum.alpha.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void updateSignature(String signature) {
		
		String id = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userRepository.updateSignature(signature, id);
	}
}
