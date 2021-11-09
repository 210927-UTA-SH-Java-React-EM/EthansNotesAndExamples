package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Post;
import com.example.models.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	public List<Post> findAll();
	public Post findByUser(User u);
	
}
