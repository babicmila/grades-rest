package com.babicmila.repository;

import org.springframework.data.repository.CrudRepository;

import com.babicmila.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}