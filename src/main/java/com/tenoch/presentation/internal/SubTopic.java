package com.tenoch.presentation.internal;

import java.util.ArrayList;
import java.util.Collection;

public class SubTopic {

	private int id;
	private String title;
	private String html;
	private Collection<Article> articles = new ArrayList<Article>();
	
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
	public Collection<Article> getArticles() {
		return articles;
	}
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}	
}
