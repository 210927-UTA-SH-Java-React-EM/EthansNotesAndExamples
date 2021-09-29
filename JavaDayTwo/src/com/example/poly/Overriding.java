package com.example.poly;

import java.io.IOException;

public class Overriding extends Parent{
	
	protected int x;
	protected String name;
	
	//We can change the return type of a method as long as its a child of the parent class' return type
	@Override
	protected String getObj() {
		return "yep";
	}
	
	//We can change the access modifier as long as we make it more accessible
	@Override
	public void changeAccess() {
		System.out.println("Changed from protected to public");
	}
	
	//We can change the throws declaration to have either less expections or children of the parent methods exception
	@Override
	protected void changeThrows() throws IOException{
		System.out.println("Changed the throws");
	}
	
	//We cannot ovveride static or private methods, but we can hide static ones
	public static String hiding() {
		return "hidden";
	}
	
	public Overriding() {
		this.name = "child";
	}
	
}
