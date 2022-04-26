package com.uniforum.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "POST", schema = "TYF_ACCOUNT")
public class Post extends RowDetails {
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
		 
		 @ManyToOne
		 @JoinColumn(name = "USER_NUM")
		 private User user;
		 
		 @ManyToOne
		 @JoinColumn(name = "POST_TYPE")
		 private TypeRef postType;
		 
		 @Column(name = "title")
		 private String title;
}