package com.example.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = res.getWriter();
		
		out.println("filter is invoked before");
		
		chain.doFilter(req, res); //send to the next resource
		
		out.println("filter is invoked after");
		
	}
	
}
