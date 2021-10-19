package com.example.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		//We can gain access to the servlet config using the getServletConfig()
		String config = getServletConfig().getInitParameter("my-config");
		
		//We can gain access to the servlet context using...
		String context = getServletContext().getInitParameter("my-context");
		
		PrintWriter out = res.getWriter();
		out.println("Our servlet config was: " + config);
		out.println("Our servlet context was: " + context);
	}
	
}
