package com.example.models;

import java.io.Serializable;

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	private String user;
	
	public Post() {
		super();
	}

	public Post(String title, String content, String user) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + ", user=" + user + "]";
	}
}
