package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Post;
import com.example.models.User;
import com.example.repository.PostRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PostService {
	
	private PostRepo pDao;
	
	public Post createPost(Post p) {
		return pDao.save(p);
	}
	
	public List<Post> getAllPosts(){
		return pDao.findAll();
	}
	
	public void likePost(int postId, User u) {
		Post p = pDao.findById(postId).get();
		p.getLikes().add(u);
		pDao.save(p);
	}
	
	public Post getPostById(int postId) {
		return pDao.findById(postId).get();
	}
	
	
}
