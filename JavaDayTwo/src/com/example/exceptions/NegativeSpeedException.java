package com.example.exceptions;

public class NegativeSpeedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NegativeSpeedException(String message) {
		super(message);
	}
	
	public NegativeSpeedException() {
		super("Cannot go a negative speed");
	}

}
