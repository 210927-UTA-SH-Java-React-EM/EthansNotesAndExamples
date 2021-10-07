package com.example.services;

import com.example.dao.PostDao;
import com.example.models.Post;

public class PostService {

	private PostDao pDao;
	
	public PostService(PostDao pdao) {
		this.pDao = pdao;
	}
	
	public void addPost(int userId, int wallId, String content) {
		Post p = new Post(userId, wallId, content);
		pDao.createPost(p);
	}
	
}
