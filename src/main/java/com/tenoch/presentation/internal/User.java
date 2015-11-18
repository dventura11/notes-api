package com.tenoch.presentation.internal;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private int id;
	
	private String user;
	private String password;
	private String name;
	private String email;
	private boolean enable;

	public User() {}
	
	public User(User user) {
		this.user = user.getUser();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.enable = user.isEnable();
		this.name = user.getName();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
