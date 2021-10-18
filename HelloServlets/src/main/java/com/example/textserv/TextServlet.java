package com.example.textserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet{

	private static final long serialVersionUID = 5423252901914437961L;
	
	//The default content type for our response and request is text/html
	//We can use the printWriter from our response object to respond with text/html directly to the client
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		
		out.println("Hello from the simple text servlet");
		System.out.println("In the doGet of the simple text servlet");
	}

}
