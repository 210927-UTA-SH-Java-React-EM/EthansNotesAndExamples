package com.example.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {

	public static void main(String[] args) {
		
		String filename = "characterStream.txt";
		//writeCharacter(filename, "Hello, we are writing to a character stream");
		readCharacters(filename);
	}
	
	private static void writeCharacter(String filename, String message) {
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write(message);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readCharacters(String filename) {
		try {
			FileReader read = new FileReader(filename);
			int i;
			while((i = read.read()) != -1) {
				System.out.println((char)i);
			}
			read.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
