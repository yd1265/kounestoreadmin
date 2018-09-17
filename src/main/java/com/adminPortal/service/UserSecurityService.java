package com.adminPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adminPortal.model.User;
import com.adminPortal.repository.UserRepository;


@Service
public class UserSecurityService implements UserDetailsService{
	@Autowired
	private UserRepository userReposotory;

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		
		User user= userReposotory.findByUsername(username);
		
		if(user==null){
		throw new UsernameNotFoundException("Username not found");
	}
		
	return user;
	}

}