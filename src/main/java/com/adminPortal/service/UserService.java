package com.adminPortal.service;
import java.util.Set;

import com.adminPortal.domain.User;
import com.adminPortal.domain.security.UserRole;


public interface UserService {
	User findByUsername(String username);
	User findByEmail(String email);
	User createUser(User user1, Set<UserRole> userRoles);
	User save(User user);

	 
}