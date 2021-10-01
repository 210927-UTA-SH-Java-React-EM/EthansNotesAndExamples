package com.example.exceptions;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 2761986612562479881L;
	
	public InvalidCredentialsException() {
		super("Invalid credentials");
	}
}
