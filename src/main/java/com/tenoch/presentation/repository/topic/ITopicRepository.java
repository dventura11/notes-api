package com.tenoch.presentation.repository.topic;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tenoch.presentation.internal.Topic;

public interface ITopicRepository extends MongoRepository<Topic, String>{
	
}