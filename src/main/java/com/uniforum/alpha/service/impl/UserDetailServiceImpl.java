package com.uniforum.alpha.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uniforum.alpha.constant.ExceptionConstants;
import com.uniforum.alpha.entity.User;
import com.uniforum.alpha.model.ForumUserDetail;
import com.uniforum.alpha.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> ouser = userRepository.findById(username);

		ouser.orElseThrow(() -> new UsernameNotFoundException(ExceptionConstants.NO_USER_FOUND_MSG.concat(username)));
		System.out.println(ouser.get());
		ForumUserDetail forumUserDetail = new ForumUserDetail(ouser.get());
		System.out.println(forumUserDetail);
		return forumUserDetail;
	}

}
