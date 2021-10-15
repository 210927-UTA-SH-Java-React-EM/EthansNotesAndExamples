package com.example.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

import com.example.dao.FileIO;
import com.example.logging.Logging;
import com.example.models.Post;

=======
import java.util.logging.Logger;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UsernameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.User;
import com.example.models.Post;


>>>>>>> 8e804db719f7e03609c42aa7ad9f7c4c750a506d
public class PostService {
	
	private String file;
	private FileIO<Post> io;
	
	public PostService(String file) {
		this.file = file;
		this.io = new FileIO<Post>(file);
	}
<<<<<<< HEAD
	
	//Get all posts from the post file
	public List<Post> getAllPosts(){
		List<Post> pList;
		
		try {
			pList = io.readObject();
		} catch (FileNotFoundException e) {
			pList = new ArrayList<Post>();
		} catch (Exception e) {
			pList = null;
			e.printStackTrace();
		}
		
		return pList;
	}
	
	public void addPost(Post p) {
		ArrayList<Post> pList;
		
		try {
			pList = io.readObject();
		} catch(FileNotFoundException e) {
			pList = new ArrayList<Post>();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		pList.add(p);
		io.writeObject(pList);
		Logging.logger.info("User: " + p.getUser() + " posted a new post");
	}
	
=======

     
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

>>>>>>> 8e804db719f7e03609c42aa7ad9f7c4c750a506d
}
