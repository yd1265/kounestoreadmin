package com.adminPortal.service;
import java.util.Set;

import com.adminPortal.model.User;
import com.adminPortal.model.security.UserRole;


public interface UserService {
	User findByUsername(String username);
	User findByEmail(String email);
	User createUser(User user1, Set<UserRole> userRoles);
	User save(User user);

	 
}