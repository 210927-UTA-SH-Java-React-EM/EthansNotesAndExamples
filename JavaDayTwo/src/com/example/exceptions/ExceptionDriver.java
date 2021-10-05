package com.example.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDriver {

	public static void main(String args[]) {
		
		/*
		try {
			throwManyExceptions(4);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound was caught");
		} catch(IOException e) {
			System.out.println("IOException was caught");
		} catch(Exception e) {
			System.out.println("Some other exception was caught");
		} finally {
			System.out.println("This block of code will run no matter what");
		}
		*/
		
		Bicycle bike = new Bicycle();
		
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		bike.speedUp(24);
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		bike.speedUp(2);
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		try {
			bike.slowDown(26);
		} catch (NegativeSpeedException e) {
			bike.speed = 0;
			bike.gear = 1;
			e.printStackTrace();
		}
		
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
	}
	
	public static void throwManyExceptions(int i) throws Exception {
		
		switch(i) {
			case 1: throw new IOException();
			case 2: throw new ClassNotFoundException();
			case 3: throw new FileNotFoundException();
			default: throw new Exception();
		
		}
		
	}
}
