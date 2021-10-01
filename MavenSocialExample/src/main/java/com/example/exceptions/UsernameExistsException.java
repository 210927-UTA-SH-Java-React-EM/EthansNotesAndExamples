package com.example.exceptions;

public class UsernameExistsException extends RuntimeException {

	private static final long serialVersionUID = 5247467395760495349L;
	
	public UsernameExistsException(String message) {
		super(message);
	}
	
	public UsernameExistsException() {
		super("Username already exists");
	}

}
