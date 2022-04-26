package com.uniforum.alpha.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.uniforum.alpha.constant.AppConstants;
import com.uniforum.alpha.util.JWTUtil;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthoraiztionTokenFilter extends OncePerRequestFilter {

	private JWTUtil jwtUtil = new JWTUtil() ;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

			System.err.println(request.getServletPath());
			String jwt = parseJwt(request);
			try {

				List<SimpleGrantedAuthority> authorities = jwtUtil.getAuthorities(jwt);
				String username = jwtUtil.getUsername(jwt);
				
				SecurityContextHolder.getContext()
						.setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
			} catch (JwtException | IllegalArgumentException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "error occured while authorization");
				log.error("AuthoraiztionTokenFilter | error occured while authorization {}", e.getMessage());
				e.printStackTrace();
				return;
			}
		filterChain.doFilter(request, response);
	}

	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// TODO Auto-generated method stub
		return request.getRequestURI().equals(AppConstants.LOGIN_PATH) || !request.getRequestURI().contains("/api/");
	}



	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}
}
