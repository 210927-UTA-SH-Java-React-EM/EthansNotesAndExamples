package com.example.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.example.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController()
@RequestMapping("user")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService uServ;
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate rest;
	
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody LinkedHashMap<String, String> user){
		
		User u = new User(0, user.get("firstName"), user.get("lastName"), user.get("username"), user.get("email"), user.get("password"));
		if(uServ.registerUser(u)) {
			return new ResponseEntity<String>("User was registered", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Username or email was already taken", HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> user){
		User u = uServ.loginUser(user.get("username"), user.get("password"));
		
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	//We no longer have direct access to posts, so we must talk to the other micro service with RestTemplate
	@GetMapping("/posts/{id}")
	public ResponseEntity<String> getUserPosts(@PathVariable("id")int id){
		String url = "http://localhost:8090/post/" + id;
		ResponseEntity<String> res = this.rest.getForEntity(url, String.class);
		return res;
	}
}
