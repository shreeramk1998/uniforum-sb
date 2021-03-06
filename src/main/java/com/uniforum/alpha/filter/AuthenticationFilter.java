package com.uniforum.alpha.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniforum.alpha.model.ForumUserDetail;
import com.uniforum.alpha.model.LoginResponseVO;
import com.uniforum.alpha.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		log.info("username : {} password : {}",username, password);
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		return authenticationManager.authenticate(authenticationToken);
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		
		JWTUtil jwtUtil = new JWTUtil();
		ForumUserDetail forumUserDetail = (ForumUserDetail) authentication.getPrincipal();
		String jwt = jwtUtil.generateToken(forumUserDetail);
		
		ObjectMapper mapper = new ObjectMapper();
		LoginResponseVO loginResponseVO = new LoginResponseVO();
		loginResponseVO.setUser(forumUserDetail.getUser());
		loginResponseVO.setJwt(jwt);
		String loginResponseVOString = mapper.writeValueAsString(loginResponseVO);
		
		response.setHeader("Authorization", "Bearer ".concat(jwt));
		response.setHeader("Content-Type","application/json;charset=UTF-8");
		response.getWriter().write(loginResponseVOString);
		response.setStatus(HttpStatus.ACCEPTED.value());
	}
	

//	@Override
//	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException failed) throws IOException, ServletException {
//		
//		
//		super.unsuccessfulAuthentication(request, response, failed);
//	}
	
}
