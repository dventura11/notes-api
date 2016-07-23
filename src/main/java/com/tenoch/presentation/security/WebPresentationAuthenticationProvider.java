package com.tenoch.presentation.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Component;

import com.tenoch.presentation.internal.User;
import com.tenoch.presentation.repository.user.IUserRepository;

@Component
public class WebPresentationAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	IUserRepository repo;
		
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String password = authentication.getCredentials().toString();
		password = Sha512DigestUtils.shaHex(password);
		
		User user = repo.findByUserAndPassword(authentication.getName(), password );
		
		if (user == null ) {
			throw new AuthenticationCredentialsNotFoundException("Usuario o contraseña invalida");
		}		
		
		Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		
		user.getRoles().forEach( role -> authorities.add(new SimpleGrantedAuthority(role)) );
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities );
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
