package com.tenoch.presentation.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.tenoch.presentation.internal.User;

public class CustomUserDetails extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -329992741074403349L;

	public CustomUserDetails(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return AuthorityUtils.createAuthorityList("ADMIN");
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isEnable();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isEnable();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isEnable();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnable();
	}

}
