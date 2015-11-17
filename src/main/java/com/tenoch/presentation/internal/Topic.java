package com.tenoch.presentation.internal;

import java.util.Collection;

public class Topic {

	private int id;
	private String title;
	private String description;
	private Collection<SubTopic> subTopics;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<SubTopic> getSubTopics() {
		return subTopics;
	}
	public void setSubTopics(Collection<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}	
}
