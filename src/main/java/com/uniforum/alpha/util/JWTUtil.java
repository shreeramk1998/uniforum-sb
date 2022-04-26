package com.uniforum.alpha.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT utility.<br>
 * 
 * @author shreeram.kulkarni
 *
 */
public class JWTUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final long TOKEN_VALIDITY_SEC =  15*60*60; // 10hrs in sec
	
	private String secret = "MbPeShVmYq3t6w9z$C&F)J@NcRfTjWnZr4u7x!A%D*G-KaPdSgVkYp2s5v8y/B?E";
	
	public String getUsername(String token) {
		
		return getClaimFromToken(token, Claims::getSubject);
	}

	public List<SimpleGrantedAuthority> getAuthorities(String token) {
		@SuppressWarnings("unchecked")
		List<String> roles = (List<String>) getCustomClaimFromToken(token, "role", List.class);
		
		return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	public Date getExpiration(String token) {
		return  getClaimFromToken(token, Claims::getExpiration);
	}
	
	// not of much use 
	public Boolean isTokenExpired(String token) {
		return getExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		String jwt = Jwts.builder().setSubject(userDetails.getUsername())
		.claim("role",
				userDetails.getAuthorities().stream().flatMap(r -> Stream.of(r.getAuthority()))
						.collect(Collectors.toList()))
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_SEC * 1000))
		.signWith(SignatureAlgorithm.HS512, secret).compact();
		System.out.println("jwt: "+jwt);
		return jwt;
	}
	
	public Boolean validationToken(String token) {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		return true;
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {

		Claims claim = getClaimByToken(token);
		return claimResolver.apply(claim);
	}
	
	private <T> T getCustomClaimFromToken(String token, String claimName, Class<T> claimType) {

		Claims claim = getClaimByToken(token);
		return claim.get(claimName, claimType);
	}
	private Claims getClaimByToken(String token) {
//		boolean signed = Jwts.parser().isSigned(jwt)
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	
	}
	
}
