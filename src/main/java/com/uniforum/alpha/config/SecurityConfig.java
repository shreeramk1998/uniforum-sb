package com.uniforum.alpha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.uniforum.alpha.constant.AppConstants;
import com.uniforum.alpha.filter.AuthenticationFilter;
import com.uniforum.alpha.filter.AuthoraiztionTokenFilter;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	private static final String[] AUTH_WHITELIST = {
	        "/swagger-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeHttpRequests()
				.antMatchers(AppConstants.LOGIN_PATH).permitAll()
				.antMatchers(AppConstants.SWAGGER_PATH+"**").permitAll()
//				.antMatchers("/api/student").hasAuthority("STUDENT")
//				.antMatchers("/api/admin").hasAuthority("ADMIN")
				.antMatchers("/**").permitAll();

		httpSecurity.csrf().disable();

		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		way 1 : default mapping/login
//		httpSecurity.addFilter(new AuthenticationFilter(getAuthenticationManager()));
//		way2 : custom porcess url
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(getAuthenticationManager());
		authenticationFilter.setFilterProcessesUrl(AppConstants.LOGIN_PATH);
		httpSecurity.addFilter(authenticationFilter);
		
		httpSecurity.addFilterBefore(new AuthoraiztionTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		// cors config
		httpSecurity.cors().configurationSource(request-> {
			CorsConfiguration corsConfig = new CorsConfiguration();
			corsConfig.applyPermitDefaultValues();
			corsConfig.addExposedHeader("Authorization");
			return corsConfig;
		});
		
//		below is not the way to handle cors
//		httpSecurity.headers().addHeaderWriter(new HeaderWriter() {
//
//			@Override
//			public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
////				response.setHeader("Access-Control-Allow-Origin", "*");
////				response.setHeader("Access-Control-Allow-Methods",
////						"ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, UNLOCK, UPDATE, VERSION-CONTROL");
////				response.setHeader("Access-Control-Max-Age", "3600");
//				response.addHeader("Access-Control-Allow-Credentials", "true");
//				response.addHeader("Access-Control-Allow-Headers",
//						"Origin, X-Requested-With, Content-Type, Accept, Key, Authorization");
//				response.addHeader("Access-Control-Allow-Origin", "*");
//				response.addHeader("Access-Control-Expose-Headers", "Authorization");
//				response.setStatus(HttpServletResponse.SC_OK);
//				response.addHeader("Access-Control-Allow-Methods",
//						"ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, UNLOCK, UPDATE, VERSION-CONTROL");
//				
//			}
//		});

	}

	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(getNoOpPasswordEncoder());
	}

	@Bean
	@Primary
	public PasswordEncoder getNoOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public PasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
