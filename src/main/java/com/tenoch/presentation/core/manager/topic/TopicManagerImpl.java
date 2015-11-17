package com.tenoch.presentation.core.manager.topic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenoch.presentation.internal.Topic;
import com.tenoch.presentation.repository.topic.ITopicRepository;

@Service
public class TopicManagerImpl implements ITopicManager {

	@Autowired
	ITopicRepository repo;
	
	/* (non-Javadoc)
	 * @see com.tenoch.presentation.core.manager.topic.ITopicManager#getAllTopics()
	 */
	@Override
	public Collection<Topic> getAllTopics(){
		return repo.getAll();		
	}

	@Override
	public Topic getTopic(int id) {
		return repo.get(id);
	}
}
