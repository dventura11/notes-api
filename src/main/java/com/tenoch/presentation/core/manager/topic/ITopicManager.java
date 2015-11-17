package com.tenoch.presentation.core.manager.topic;

import java.util.Collection;

import com.tenoch.presentation.internal.Topic;

public interface ITopicManager {

	Collection<Topic> getAllTopics();
	Topic getTopic(int id);

}