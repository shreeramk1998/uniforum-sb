package com.uniforum.alpha.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppConstants {

	public static final String BASE_API = "/api";

	public static final String LOGIN_PATH = "/api/login";
	public static final String SWAGGER_PATH = "/swagger-ui/";

	public static class PostApiConstants {

		public static final String POST_CONTROLLER_BASE = "/post";

		public static final String GET_POSTS = "/fetch";

		public static final String SAVE_POSTS = "/save";

		public static final String GET_POST_COMMENT = "/comment/fetch/{postNum}";

		public static final String SAVE_POST_COMMENT = "/comment/save";
		
		public static final String GET_POST_COMMENTS = "/comment/fetch";

		public static final String GET_USER_POSTS = "/fetch/{userNum}";
		
		public static final String UPVOTE_POST = "/upvote";

	}

	public static class MetadataApiConstants {

		public static final String METADATA_CONTROLLER_BASE = "/metadata";

		public static final String GET_TYPE_GROUP_REF = "/typegroupref/fetch";

	}
	
	public static class UserApiConstants {
		
		public static final String USER_CONTROLLER_BASE = "/user";
		
		public static final String SAVE_USER = "/save";
		
		public static final String UPDATE_USER_SIGNATURE = "/signature";
				
	}
}
