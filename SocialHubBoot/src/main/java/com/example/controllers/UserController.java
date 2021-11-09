package com.example.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Post;
import com.example.models.User;
import com.example.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/users")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class UserController {

	private UserService uServ;
	
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody LinkedHashMap<String, String> user){
		
		User u = new User(0, user.get("firstName"), user.get("lastName"), user.get("username"), user.get("email"), user.get("password"), new ArrayList<Post>());
		if(uServ.registerUser(u)) {
			return new ResponseEntity<String>("User was created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Username or email already registered to a user", HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> user){
		User u = uServ.loginUser(user.get("username"), user.get("password"));
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		}
		else {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		User u = uServ.displayUser(username);
		return u;
	}
	
}
