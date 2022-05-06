package com.uniforum.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_POST_XREF", schema = "TYF_ACCOUNT")
@IdClass(UserPostXrefPk.class)
public class UserPostXref {

	@Id
	@Column(name = "USER_NUM", nullable = false)
	@EqualsAndHashCode.Include
	private Long userNum;
	
	@Id
	@Column(name = "POST_NUM" , nullable = false)
	@EqualsAndHashCode.Include
	private Long postNum;
	
	@Column(name = "UPVOTE_FLG")
	private Boolean upvoteFlag;
	
}
