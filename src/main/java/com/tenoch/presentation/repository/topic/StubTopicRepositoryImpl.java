package com.tenoch.presentation.repository.topic;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.tenoch.presentation.internal.Article;
import com.tenoch.presentation.internal.SubTopic;
import com.tenoch.presentation.internal.Topic;

@Service
public class StubTopicRepositoryImpl implements ITopicRepository {

	private static int id = 1;
	
	@Override
	public Collection<Topic> getAll() {
		Collection<Topic> topics = new ArrayList<Topic>();
		topics.add(getTopic("Java SE 6 Certification"));
		topics.add(getTopic("Spring Core V4 Certification"));
		topics.add(getTopic("Spring Web V4 Certification"));
		topics.add(getTopic("Oracle Certification"));		
		return topics;
	}

	private Topic getTopic(String title) {
		Topic topic = new Topic();
		topic.setDescription("Descripción de " + title);
		topic.setId(id++);
		topic.setTitle(title);		
		return topic;
	}

	@Override
	public Topic get(int id) {
		Topic topic = getTopic("Java");
		topic.setId(id);
		topic.setSubTopics(getSubtopics());
		return topic;
	}

	private Collection<SubTopic> getSubtopics() {
		Collection<SubTopic> subtopics = new ArrayList<SubTopic>();
		for (int i = 0; i < 1; i++) {
			subtopics.add(getSubtopic("Herencia"+i));
			subtopics.add(getSubtopic("Polimorfismo"+i));
			subtopics.add(getSubtopic("Casteo"+i));
			subtopics.add(getSubtopic("Virtual Machine"+i));
		}
		return subtopics;
	}

	private SubTopic getSubtopic(String title) {
		SubTopic subtopic = new SubTopic();
		subtopic.setId(id++);
		subtopic.setTitle(title);
		subtopic.setHtml("Mucho pero no tanto html sobre " + title + "<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget aliquet enim. Sed varius nec nunc ac scelerisque. Suspendisse in orci ut urna lacinia dignissim. Fusce non fringilla nulla, vel interdum enim. Cras et ante id ante elementum finibus. Aenean posuere sapien vitae sapien malesuada, vitae ornare est dictum. Aenean rutrum diam sed nulla rutrum euismod. Phasellus dui sem, blandit at semper ut, porta sed nisi. In luctus pulvinar lobortis. Sed accumsan ultricies lorem. In a sollicitudin turpis. Donec augue risus, rhoncus blandit nulla sed, fermentum egestas enim. Nulla augue lorem, consequat et augue quis, pharetra imperdiet lorem. Morbi et consectetur massa, in lacinia nibh. Donec vehicula felis ut dui ultricies, vel fermentum turpis fringilla. Nam nunc dui, consequat nec accumsan non, cursus in risus. Nullam lobortis hendrerit elit, vitae dictum lorem. Phasellus in commodo risus. Integer scelerisque bibendum nunc sodales hendrerit. Nulla efficitur non arcu in vulputate. Nullam vitae commodo odio.");
		if(id%4==0)subtopic.setArticles(getArticles(title));		
		return subtopic;
	}

	private Collection<Article> getArticles(String title) {
		Collection<Article> articles =  new ArrayList<Article>();
		for (int j = 0; j < 3; j++) {
			articles.add(getArticle( title + "_"+j));
		}
		return articles;
	}

	private Article getArticle(String title) {
		Article article = new Article();
		article.setId(id++);
		article.setTitle(title);
		article.setHtml("Aqui va aun monton de html sobre " + title + "<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget aliquet enim. Sed varius nec nunc ac scelerisque. Suspendisse in orci ut urna lacinia dignissim. Fusce non fringilla nulla, vel interdum enim. Cras et ante id ante elementum finibus. Aenean posuere sapien vitae sapien malesuada, vitae ornare est dictum. Aenean rutrum diam sed nulla rutrum euismod. Phasellus dui sem, blandit at semper ut, porta sed nisi. In luctus pulvinar lobortis. Sed accumsan ultricies lorem. In a sollicitudin turpis. Donec augue risus, rhoncus blandit nulla sed, fermentum egestas enim. Nulla augue lorem, consequat et augue quis, pharetra imperdiet lorem. Morbi et consectetur massa, in lacinia nibh. Donec vehicula felis ut dui ultricies, vel fermentum turpis fringilla. Nam nunc dui, consequat nec accumsan non, cursus in risus. Nullam lobortis hendrerit elit, vitae dictum lorem. Phasellus in commodo risus. Integer scelerisque bibendum nunc sodales hendrerit. Nulla efficitur non arcu in vulputate. Nullam vitae commodo odio.");
		return article;
	}

}
