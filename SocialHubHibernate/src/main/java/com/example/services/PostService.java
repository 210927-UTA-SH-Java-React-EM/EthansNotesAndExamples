package com.example.services;

import java.util.List;
import java.util.Set;

import com.example.dao.PostDao;
import com.example.dao.PostDaoHibernate;
import com.example.dao.UserDao;
import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;

public class PostService {

	private PostDaoHibernate pDao;
	private UserDao uDao;
	
	public PostService(PostDaoHibernate pdao, UserDao uDao) {
		this.pDao = pdao;
		this.uDao = uDao;
	}
	
	
	public Post addPost(User u, String content) {
		Post p = new Post(u, content);
		pDao.createPost(p);
		u.getPosts().add(p);
		uDao.updateUser(u);
		return p;
	}
	
	
	public List<PostDisplay> getAllPosts(){
		return pDao.getAllPosts();
	}
	
	public Post likePost(User u, Post p) {
		Set<User> likes = p.getLikes();
		likes.add(u);
		p.setLikes(likes);
		
		Set<Post> likedPosts = u.getLikePosts();
		likedPosts.add(p);
		
		uDao.updateUser(u);
		return pDao.updatePost(p);
	}
	
}
