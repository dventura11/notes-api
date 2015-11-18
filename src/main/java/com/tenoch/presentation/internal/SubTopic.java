package com.tenoch.presentation.internal;

import java.util.ArrayList;
import java.util.Collection;

public class SubTopic {

	private Long id = System.currentTimeMillis();
	private String title;
	private String html;
	private Collection<Article> articles = new ArrayList<Article>();
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof SubTopic){
			return this.id.equals((((SubTopic)obj).getId()));
		}
		return super.equals(obj);
	}
}
