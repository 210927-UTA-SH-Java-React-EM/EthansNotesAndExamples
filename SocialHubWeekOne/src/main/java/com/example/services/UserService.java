 package com.example.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UsernameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Post;
import com.example.models.User;

public class UserService {
	
	private String file;
	private FileIO<User> io;
	private FileIO<Post> ioPost;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
		this.ioPost = new FileIO<Post>(file);
		
	}
	
	
	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public User signUp(String firstName, String lastName, String username, String password) {
		
		ArrayList<User> users;
		
		try {
			users = io.readObjects();
		} catch(FileNotFoundException e) {
			System.out.println("Creating a blank arraylist");
			users = new ArrayList<User>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		//Check to see if the users username is already stored
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				//Throw an exception that username already exists
				Logging.logger.warn("Username created that already exists in the database");
				throw new UsernameAlreadyExistsException();
			}
		}
		
		User u = new User(firstName, lastName, username, password);
		
		users.add(u);
		io.writeObjects(users);
		
		return u;
	}
	
	public User login(String username, String password) throws InvalidCredentialsException {
		
		ArrayList<User> users;
		
		try {
			users = io.readObjects();
		} catch(FileNotFoundException e) {
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for(int i=0; i<users.size(); i++) {
			//If the username exists in the file, then we want to check the password
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password)) {
					Logging.logger.info("User: " + username + " was logged in");
					System.out.println("User was signed in");
					return users.get(i);
				} else {
					Logging.logger.warn("User tried logging in with invalid credentials");
					//Throw an invalidcredentialsexception
					throw new InvalidCredentialsException();
				}
			}
		}
		Logging.logger.warn("User tried signing in with invalid username");
		throw new InvalidCredentialsException();
	}
	
	public void post(Post post)
	{
		ArrayList<Post> posts = new ArrayList<Post>();
		
		posts.add(post);
		
		this.ioPost.writeObjects(posts);

	}
	
}
