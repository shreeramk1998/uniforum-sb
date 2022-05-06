package com.uniforum.alpha.service;

import com.uniforum.alpha.entity.User;

public interface UserService {

	public User saveUser(User user);

	public void updateSignature(String signature);

}
