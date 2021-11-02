package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.LoginController;
import com.example.controllers.PostController;
import com.example.controllers.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Dispatcher {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		System.out.println("In the Servlet Dispatcher with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/SocialHubHibernate/api/login":
				LoginController.login(req, res);
				break;
			case "/SocialHubHibernate/api/posts":
				PostController.handlePosts(req, res);
				break;
			case "/SocialHubHibernate/api/session":
				SessionController.getSession(req, res);
		}
	}
	
}
