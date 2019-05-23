package com.adminPortal.service;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminPortal.domain.User;
import com.adminPortal.domain.security.UserRole;
import com.adminPortal.repository.RoleRepository;
import com.adminPortal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private static final Logger LOG= LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public User findByUsername(String username) {
		User user=userRepository.findByUsername(username);
		if(user==null){
			LOG.info("Usrname not Exist");

		}
		return user;
	}


	@Override
	public User findByEmail(String email) {
		User user=userRepository.findByEmail(email);
          if(user==null){
  			LOG.info("Email not Exist");

		}
		return user;
	 
	}


	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
      User localUser=userRepository.findByUsername(user.getUsername());
		
		if(localUser!=null){
			LOG.info("User already Exist");
		}else {
			for(UserRole ur: userRoles){
          roleRepository.save(ur.getRole());
          
			
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser=userRepository.save(user);
		}
		
		
		return localUser;
			
	}

	
	@Override
	public User save(User user) {
		return userRepository.save(user);
		
	}

}

