package com.tenoch.presentation.core.manager.topic;

import java.util.Collection;

import com.tenoch.presentation.internal.Article;
import com.tenoch.presentation.internal.SubTopic;
import com.tenoch.presentation.internal.Topic;

public interface ITopicManager {

	Collection<Topic> getAllTopics();
	Topic getTopic(String id);
	Topic insert(Topic topic);
	void delete(String id);
	Topic addSubTopic(String id, SubTopic subTopic);
	SubTopic getSubTopic(String id, SubTopic subTopic);
	SubTopic updateSubTopic(String id, SubTopic subTopic);
	SubTopic deleteSubTopic(String id, SubTopic subTopic);
	void addArticle(String id, SubTopic subTopic, Article article);

}