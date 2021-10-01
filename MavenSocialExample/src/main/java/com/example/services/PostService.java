package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.example.dao.FileIO;
import com.example.logging.Logging;
import com.example.models.Post;

public class PostService {
	
	private String file;
	private FileIO<Post> io;
	
	public PostService(String file) {
		this.file = file;
		this.io = new FileIO<Post>(file);
	}
	
	// Cannot create post if title and username exist on another post
	public Post createPost(String title, String content, String username) {
		ArrayList<Post> Posts;
		
		try {
			Posts = io.readObjects();
		} catch (FileNotFoundException e) {
			System.out.println("Creating a blank arraylist");
			Posts = new ArrayList<Post>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Post Post = new Post(title, content, username);
		
		Posts.add(Post);
		
		io.writeObjects(Posts);
		
		return Post;
	}
	
	public ArrayList<Post> retrievePosts(String author) {
		ArrayList<Post> posts;
		ArrayList<Post> usersPosts = new ArrayList<Post>();
		
		try {
			posts = io.readObjects();
		} catch (FileNotFoundException e) {
			posts = new ArrayList<Post>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for (Post post : posts) {
			if (post.getAuthor().equals(author))
				usersPosts.add(post);
		}
		
		return usersPosts;
	}
}
