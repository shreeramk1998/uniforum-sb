package com.uniforum.alpha.model;

import com.uniforum.alpha.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseVO {

	private String jwt;
	private User user;
}
