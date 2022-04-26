package com.uniforum.alpha.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QueryConstants {

	public static class PostQueryConstants {
		public static final String FIND_ALL_POST_BY_USER = "SELECT p FROM Post p WHERE p.user.userNum = :userNum ORDER BY p.rowUpdateStamp DESC";
	}
	
	public static class CommentQueryConstants {
		public static final String FIND_ALL_POST_COMMENT = "SELECT c FROM Comment c WHERE c.post.postNum = :postNum";
		public static final String FIND_ALL_COMMENT_REPLIES = "SELECT c FROM Comment c WHERE c.parentNum = :commentNum";
	}
	
}
