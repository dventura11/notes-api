package com.tenoch.presentation.repository.user;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tenoch.presentation.internal.User;

public interface IUserRepository extends MongoRepository<User, BigInteger>{

	User findByUser(String user);
	
	User findByUserAndPassword(String user, String password);
	
}
