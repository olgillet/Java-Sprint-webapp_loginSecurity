package com.app.model;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;

public class PrincipalUser implements UserDetails {
	private User user;
	
	public PrincipalUser(User user) {
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist");
		}
		this.user = user;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@PreAuthorize("hasRole('ROLE_ADMIN’)")
	public @interface IsAdmin {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		myAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return myAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// Just for test
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// Just for test
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// Just for test
		return true;
	}

	@Override
	public boolean isEnabled() {
		// Just for test
		return true;
	}
}