package com.example.htmlserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//We can also use printwriter to send html
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>Hello from our HTML Servlet</h1></body></html>");
		System.out.println("Inside do get of the html servlet");
	}
	
}
