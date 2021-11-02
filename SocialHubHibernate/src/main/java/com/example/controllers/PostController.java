package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.PostDao;
import com.example.dao.PostDaoDB;
import com.example.dao.PostDaoHibernate;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.dao.UserDaoHibernate;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PostController {
	
	private static PostDaoHibernate pDao = new PostDaoHibernate();
	private static UserDaoHibernate uDao = new UserDaoHibernate();
	private static PostService pServ = new PostService(pDao, uDao);
	private static UserService uServ = new UserService(uDao);
	
	public static void handlePosts(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		if(req.getMethod().equals("GET")) {
			List<PostDisplay> posts = pServ.getAllPosts();
			res.getWriter().write(new ObjectMapper().writeValueAsString(posts));
		} else {
			
			//To read stringified JSON data
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
			
			String data = buffer.toString();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode parsedObj = mapper.readTree(data);
			
			int userId = Integer.parseInt(parsedObj.get("userId").asText());
			int wallId = userId;
			String content = parsedObj.get("content").asText();
			
			User u = uDao.getUserById(userId);
			
			pServ.addPost(u, content);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new post");
			
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		}
	}
	
}
