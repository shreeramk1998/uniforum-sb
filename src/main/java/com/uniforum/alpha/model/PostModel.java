package com.uniforum.alpha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {

	 private Long postNum;
	 
	 private String text;
	 private String title;
	 
	 private Long upvote;
	 
	 private Long topicNum;
	 
	 private Long userNum;
	 
	 private String userName;
	 
	 private Long postType;
}
