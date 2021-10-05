package com.example.poly;

import java.io.IOException;

public class Parent {
	
	protected int x;
	protected String name;
	protected boolean inherited = true;
	
	public static void overloadMe() {
		System.out.println("no-arg method");
	}
	
	public static void overloadMe(String s) {
		System.out.println("method with one arg: " + s);
	}
	
	public static void overloadMe(String s, int i) {
		System.out.println("method with two args: " + s + " " + i);
	}
	
	public static void overloadMe(int i, String s) {
		System.out.println("method with two args: " + i + " " + s);
	}
	
	protected Object getObj() {
		System.out.println("can we change the return type?");
		return new Object();
	}
	
	protected void changeThrows() throws Exception{
		System.out.println("Can we change the throws?");
	}
	
	protected void changeAccess() {
		System.out.println("can we change the access?");
	}
	
	public static String hiding() {
		return "hide me!";
	}
	
	public Parent() {
		x=5;
		name="parent";
	}
	
}
