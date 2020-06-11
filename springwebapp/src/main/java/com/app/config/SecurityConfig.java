package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.app.services.AuthService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers
	 * ("/**").hasAnyRole("ADMIN", "USER") .and().formLogin(); }
	 */

	@Autowired
	private AuthService authService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/**").hasAnyRole("ADMIN", "USER")
				.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/home", true)
					.failureUrl("/login?error=true")
					.permitAll()
				.and()
				.logout()
					.logoutSuccessUrl("/my_logout-page").permitAll();
	}


	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.authService);
	}

}