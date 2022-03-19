package com.uniforum.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "POST", schema = "TYF_ACCOUNT")
public class Post {
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
		 
		 @Column(name = "USER_NUM")
		 private Long userNum;
		 
		 @Column(name = "POST_TYPE")
		 private Long postType;
		 
}