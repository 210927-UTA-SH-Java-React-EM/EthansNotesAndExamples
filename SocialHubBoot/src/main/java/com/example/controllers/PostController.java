package com.example.controllers;

import java.util.HashSet;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Post;
import com.example.models.User;
import com.example.service.PostService;
import com.example.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/posts")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class PostController {
	
	private UserService uServ;
	private PostService pServ;
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody LinkedHashMap<String, String> post){
		
		User u = uServ.getUserById(Integer.parseInt(post.get("userId")));
		Post p = new Post(0, post.get("content"), u, new HashSet<User>());
		
		return new ResponseEntity<Post>(pServ.createPost(p), HttpStatus.CREATED);
	}
	
	@PostMapping("/like")
	public ResponseEntity<Post> likePost(@RequestBody LinkedHashMap<String, Integer> post){
		User u = uServ.getUserById(post.get("userId"));
		pServ.likePost(post.get("postId"), u);
		return new ResponseEntity<Post>(pServ.getPostById(post.get("postId")), HttpStatus.OK);
	}
	
}
