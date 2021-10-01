package com.example.services;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UsernameExistsException;
import com.example.logging.Logging;
import com.example.models.User;

public class UserService {
	
	private String file;
	private FileIO<User> io;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	
	public User signUp(String firstName, String lastName, String username, String password) {
		ArrayList<User> users;
		
		try {
			users = io.readObjects();
		} catch (FileNotFoundException e) {
			System.out.println("Creating a blank arraylist");
			users = new ArrayList<User>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for (User user : users)
			if (user.getUsername().equals(username)) {
				Logging.logger.warn("Username created that already exists in database");
				throw new UsernameExistsException();
			}
		
		User user = new User(firstName, lastName, username, password);
		
		users.add(user);
		
		io.writeObjects(users);
		
		return user;
	}
	
	public User logIn(String username, String password) throws InvalidCredentialsException {
		ArrayList<User> users;
		
		try {
			users = io.readObjects();
		} catch (FileNotFoundException e) {
			users = new ArrayList<User>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				if (user.getPassword().equals(password)) {
					Logging.logger.info("User " + username + " logged in");
					System.out.println("User was signed in");
					return user;
				}
				Logging.logger.warn("Invalid credentials supplied by user");
				throw new InvalidCredentialsException();
			}
		}
		
		Logging.logger.warn("Invalid credentials supplied by user");
		throw new InvalidCredentialsException();
	}

}
