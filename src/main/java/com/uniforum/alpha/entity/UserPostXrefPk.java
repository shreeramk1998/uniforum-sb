package com.uniforum.alpha.entity;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

public class UserPostXrefPk implements Serializable {
	
	private static final long serialVersionUID = -1557821626283625915L;
	
	@EqualsAndHashCode.Include
	private Long userNum;
	@EqualsAndHashCode.Include
	private Long postNum;
} 