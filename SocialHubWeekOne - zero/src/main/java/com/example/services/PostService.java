package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UsernameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.User;
import com.example.models.Post;


public class PostService {
	
	private String file;
	private FileIO<Post> io;
	
	public PostService(String file) {
		this.file = file;
		this.io = new FileIO<Post>(file);
	}

     
	public Post content(String title, String content ,String user)
	{
	    ArrayList<Post> postlist;
	   
		
		try {
			postlist = io.readObjects();
		} catch(FileNotFoundException e) {
			System.out.println("Creating a blank arraylist");
			postlist = new ArrayList<Post>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Post post = new Post(title,content,user);
		
		postlist.add(post);
		io.writeObjects(postlist);
		
         return post;
	}
	
    
	public ArrayList<Post> readPosts()
	{
	    ArrayList<Post> postlist;
	   
		
		try {
			postlist = io.readObjects();
		} catch(FileNotFoundException e) {
			System.out.println("Creating a blank arraylist");
			postlist = new ArrayList<Post>();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return postlist;
			
	}

}
