package com.uniforum.alpha.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QueryConstants {

	public static class NativeQueryConstants {
		
		public static final String FIND_ALL_POSTS_LOGGED_IN_USER = "findAllPostsLoggedInUser";
	}
	
	public static class PostQueryConstants {
		
		public static final String FIND_ALL_POST_BY_USER = "SELECT p FROM Post p where p.user.userNum = :userNum ORDER BY p.rowUpdateStamp DESC";
//		public static final String FIND_POST_BY_USER = "SELECT p FROM Post p where p.postNum = :postNum";
//		public static final String FIND_ALL_POST = "select * , exists(select upx.user_num from tyf_account.user_post_xref upx left join tyf_user.user u on u.user_num = upx.user_num where upx.post_num = p.post_num and u.id = :loggedInUsername and upx.upvote_flg = true) as upvote_flg from tyf_account.post p left join tyf_user.user u on u.user_num = p.owner_user_num left join tyf_config.type_ref tr on tr.type_ref_num = p.post_type order by p.row_update_stp desc";
		public static final String FIND_ALL_POST = "SELECT p from Post p ORDER BY p.rowUpdateStamp DESC";
		public static final String FIND_POST_BY_ID = "SELECT p from Post p where p.postNum = :postNum"; 
		
	}
	
	public static class CommentQueryConstants {
		public static final String FIND_ALL_POST_COMMENT = "SELECT c FROM Comment c WHERE c.postNum = :postNum";
		public static final String FIND_ALL_COMMENT_REPLIES = "SELECT c FROM Comment c WHERE c.parentNum = :commentNum";
	}
	
	public static class UserQueryConstants {
		
		public static final String UPDATE_USER_SIGNATURE = "update User set signature = :signature where id = :id";
	}
}
