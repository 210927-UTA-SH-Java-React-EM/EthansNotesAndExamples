package com.example.models;

import java.io.Serializable;

public class Post implements Serializable {

	// Serializable ID
	private static final long serialVersionUID = 8634470129096296612L;

	
	// Post info strings
	
	private String title;
	private String content;
	private String author;
	
	
	// Constructors
	
	public Post() {
		super();
	}
	
	public Post(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
	// Getters / Setters
	
	public String getTitle() { return title; }
	
	public String getContent() { return content; }
	
	public String getAuthor() { return author; }
	
	public void setTitle(String title) { this.title = title; }
	
	public void setContent(String content) { this.content = content; }
	
	public void setAuthor(String author) { this.author = author; }
	
	
	@Override
	public String toString() {
		return title + "\n  by " + author + "\n" + content + "\n";
	}
	
}
