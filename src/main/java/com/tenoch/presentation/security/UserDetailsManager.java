package com.tenoch.presentation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tenoch.presentation.internal.User;
import com.tenoch.presentation.repository.user.IUserRepository;

@Service
public class UserDetailsManager implements UserDetailsService{

	@Autowired
	IUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= repo.findByUser(username);		
		return new CustomUserDetails(user);
	}

}
