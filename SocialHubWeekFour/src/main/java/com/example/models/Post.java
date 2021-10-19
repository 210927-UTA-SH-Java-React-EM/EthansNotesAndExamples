package com.example.models;

/*
 * create table if not exists posts(
	post_id int primary key generated always as identity,
	author_id int references users(id) not null,
	wall_user_id int references users(id) not null,
	post_content varchar(500) not null
	);
 *  
 */

public class Post {
	
	private int postId;
	private int authorId;
	private int wallId;
	private String postContent;
	
	public Post() {
		
	}
	
	//This constructor will be used to create new posts based off of database data
	public Post(int id, int authorId, int wallId, String content) {
		this.postId = id;
		this.authorId = authorId;
		this.wallId = wallId;
		this.postContent = content;
	}
	
	//This constructor will be used to create a new post to be put in the database
	public Post(int authorId, int wallId, String content) {
		this.authorId = authorId;
		this.wallId = wallId;
		this.postContent = content;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getWallId() {
		return wallId;
	}

	public void setWallId(int wallId) {
		this.wallId = wallId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", authorId=" + authorId + ", wallId=" + wallId + ", postContent="
				+ postContent + "]";
	}
}
