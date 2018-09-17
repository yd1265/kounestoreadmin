package com.adminPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminPortal.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);

}
