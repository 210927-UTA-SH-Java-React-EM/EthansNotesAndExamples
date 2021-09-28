package com.example.stringbuildbuff;

public class StringBuilderBuffer {
	
	public static void main(String args[]) {
		
		//String builder object, is a string object that is mutable but not thread safe
		StringBuilder sb = new StringBuilder("Hello from");
		sb.append(" from the other side");
		
		System.out.println(sb);
		String output = sb.toString();
		
		//StringBuffer is a string object that is mutable and is threadsafe
		StringBuffer sBuff = new StringBuffer("Walter");
		sBuff.append(" White");
		System.out.println(sBuff);
		
	}
	
}
