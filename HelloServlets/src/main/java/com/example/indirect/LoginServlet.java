package com.example.indirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	//If we get a 'GET' request to /login we will forward the user to login.html
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//We can use our RequestDispatcher forward method to serve static webpages to our client
		req.getRequestDispatcher("login.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//We can use servlets to handle form submissions from the client
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		if(!username.equals("rick") || !password.equals("password")) {
			//We will redirect back to the login page if the username or password is incorrect
			req.getRequestDispatcher("login.html").forward(req, res);
		} else {
			res.sendRedirect("profile");
		}
	}

}
