package com.tenoch.presentation.repository.topic;

import java.util.Collection;

import com.tenoch.presentation.internal.Topic;

public interface ITopicRepository {

	Collection<Topic> getAll();

	Topic get(int id);

}