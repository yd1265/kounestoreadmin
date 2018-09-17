package com.adminPortal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminPortal.model.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	  Role findByName(String name);

}
