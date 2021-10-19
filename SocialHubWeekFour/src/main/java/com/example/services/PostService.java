package com.example.services;

import java.util.List;

import com.example.dao.PostDao;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public class PostService {

	private PostDao pDao;
	
	public PostService(PostDao pdao) {
		this.pDao = pdao;
	}
	
	public void addPost(int userId, int wallId, String content) {
		Post p = new Post(userId, wallId, content);
		pDao.createPost(p);
	}
	
	public List<PostDisplay> getAllPosts(){
		return pDao.getAllPosts();
	}
	
	public User loadUserPosts(User u) {
		return pDao.getUserPosts(u);
	}
	
}
