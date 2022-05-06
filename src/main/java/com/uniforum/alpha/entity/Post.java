package com.uniforum.alpha.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "POST", schema = "TYF_ACCOUNT")
public class Post extends RowDetails  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_NUM")
	private Long postNum;

	@Column(name = "TEXT")
	private String text;

	@Column(name = "UPVOTE")
	private Long upvote;

	@Column(name = "TOPIC_NUM")
	private Long topicNum;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "OWNER_USER_NUM" )
	@JsonIgnoreProperties({ "hibernateLazyInitializer" })
	private User user;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "POST_TYPE")
	@JsonIgnoreProperties({ "hibernateLazyInitializer" })
	private TypeRef postType;

	@Column(name = "title")
	private String title;
}