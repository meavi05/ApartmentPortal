/**
 * 
 */
package com.apartment.apartmentPortal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.apartment.apartmentPortal.exception.CustomAuthenticationEntryPoint;
import com.apartment.apartmentPortal.security.JwtTokenFilterConfigurer;
import com.apartment.apartmentPortal.security.JwtTokenProvider;

/**
 * @author avi08
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	    // Disable CSRF (cross site request forgery)
	    http.csrf().disable();

	    // No session will be created or used by spring security
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.cors();
		http.headers().frameOptions().sameOrigin();
		/*
		 * http.authorizeRequests() .antMatchers("/**").permitAll()
		 * .antMatchers("/authorizeUser*").authenticated()
		 * .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());
		 */
		
		
		// Entry points
	    http.authorizeRequests()//
	        .antMatchers("/register").permitAll()//
	        .antMatchers("/login").permitAll()//
	        .antMatchers("/h2-console/**/**").permitAll()
	        // Disallow everything else..
	        .anyRequest().authenticated();
	    
	 // Apply JWT
	    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}

	@Bean
	@Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
	} 
}
