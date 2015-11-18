package com.tenoch.presentation.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tenoch.presentation.internal.User;

public interface IUserRepository extends MongoRepository<User, Integer>{
	
	User findByUser(String user);
	
}
