package com.uniforum.alpha.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "COMMENT", schema = "TYF_ACCOUNT")
public class Comment extends RowDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMENT_NUM")
	private Long commentNum;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "POST_NUM")
	private Long postNum;
	
	@Column(name = "PARENT_NUM")
	private Long parentNum;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "USER_NUM")
	private User user;
	
	@Transient
	public List<Comment> replies;
	
}