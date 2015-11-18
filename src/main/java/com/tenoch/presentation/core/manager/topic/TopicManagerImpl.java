package com.tenoch.presentation.core.manager.topic;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenoch.presentation.internal.Article;
import com.tenoch.presentation.internal.SubTopic;
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
		return repo.findAll();
	}

	@Override
	public Topic getTopic(String id) {
		return repo.findOne(id);
	}

	@Override
	public Topic insert(Topic topic) {
		return repo.insert(topic);
	}

	@Override
	public void delete(String id) {
		repo.delete(id);
	}

	@Override
	public Topic addSubTopic(String id, SubTopic subTopic) {
		Topic topic = repo.findOne(id);
		if(topic.getSubTopics() == null){
			topic.setSubTopics(new ArrayList<SubTopic>());
		}
		topic.getSubTopics().add(subTopic);
		return repo.save(topic);
	}

	@Override
	public SubTopic getSubTopic(String id, SubTopic subTopic) {
		Topic topic = repo.findOne(id);
		if(topic.getSubTopics() != null){
			for(SubTopic s: topic.getSubTopics()){
				if(s.getId().equals(subTopic.getId())){
					return s;
				}
			}	
		}
		return subTopic;
	}

	@Override
	public SubTopic updateSubTopic(String id, SubTopic subTopic) {
		Topic topic = repo.findOne(id);
		if(topic.getSubTopics() != null){
			for(SubTopic s: topic.getSubTopics()){
				if(s.getId().equals(subTopic.getId())){
					s.setHtml(subTopic.getHtml());
					subTopic = s;
				}
			}	
		}
		repo.save(topic);
		return subTopic;	
	}

	@Override
	public SubTopic deleteSubTopic(String id, SubTopic subTopic) {
		SubTopic existedSubTopic = getSubTopic(id, subTopic);
		Topic topic = repo.findOne(id);
		topic.getSubTopics().removeIf(s -> s.getId().equals(subTopic.getId()));
		repo.save(topic);
		return existedSubTopic;
	}

	@Override
	public void addArticle(String id, SubTopic subTopic, Article article) {
		Topic topic = repo.findOne(id);
		if(topic.getSubTopics() != null){
			for(SubTopic s: topic.getSubTopics()){
				if(s.getId().equals(subTopic.getId())){
					if(s.getArticles() == null){
						s.setArticles(new ArrayList<Article>());
					}
					s.getArticles().add(article);
				}
			}	
		}
		repo.save(topic);
	}

}
