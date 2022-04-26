package com.uniforum.alpha.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.uniforum.alpha.entity.User;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class ForumUserDetail implements UserDetails {


	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private List<SimpleGrantedAuthority> authorities;
	
	public ForumUserDetail(User user) {
		this.authorities = user.getRoleList().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		this.password = user.getPassword();
		this.username = user.getId();
	}
	
//	public ForumUserDetail(String username,String password, Collection<SimpleGrantedAuthority> authorities) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.authorities = authorities.stream().collect(Collectors.toCollection(ArrayList::new));
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
