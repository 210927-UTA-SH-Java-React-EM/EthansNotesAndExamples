package com.example.fileio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerIO {
	
	private static ObjectIO<User> io = new ObjectIO<User>();
	private static final String FILE = "users.txt";
	
	public static void main(String[] args) {
		//Get our scanner
		Scanner scan = new Scanner(System.in);
		
		ArrayList<User> users = null;
		
		try {
			users = io.readObjects(FILE);
		} catch (FileNotFoundException e) {
			System.out.println("The users file did not exist");
			users = new ArrayList<User>();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//We can get user input using the scanner.nextLine()
		System.out.print("Please enter your first name: ");
		String first = scan.nextLine();
		
		System.out.print("Please enter your last name: ");
		String last = scan.nextLine();
		
		System.out.print("Please enter a username: ");
		String username = scan.nextLine();
		
		System.out.print("Please enter a password: ");
		String password = scan.nextLine();
		
		User u = new User(first, last, password, username);
		
		users.add(u);
		io.writeObjects(FILE, users);
		
		System.out.println("Other users regsitered include: ");
		try {
			users = io.readObjects(FILE);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
	
}
