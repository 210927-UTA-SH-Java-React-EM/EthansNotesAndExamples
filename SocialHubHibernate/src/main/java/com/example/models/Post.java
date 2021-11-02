package com.example.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	//Instead of storing an author ID, we can just store the entire user, and hibernate will make the relationship for us
	
	//Many posts belong to one user
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="content")
	private String postContent;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="post_likes_junction",
		joinColumns= {@JoinColumn(name="post_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id")}
	)
	Set<User> likes = new HashSet<User>();
	
	
	
	public Post() {
		
	}
	
	//This constructor will be used to create new posts based off of database data
	public Post(int id, User u, String content) {
		this.postId = id;
		this.user = u;
		this.postContent = content;
	}
	
	//This constructor will be used to create a new post to be put in the database
	public Post(User u, String content) {
		this.user = u;
		this.postContent = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + "user= " + user.getUsername() + ", postContent="
				+ postContent + "]";
	}
}
