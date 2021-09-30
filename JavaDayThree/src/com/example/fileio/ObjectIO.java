package com.example.fileio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectIO<T> {
	
	public static void main(String[] args) {
		
		ObjectIO<User> io = new ObjectIO<User>();
		
		ArrayList<User> userList = new ArrayList<User>();
		
		String filename = "objectStore.txt";
		
		userList.add(new User("Summer", "Smith", "sssumertime", "ssmith"));
		userList.add(new User("Jerry", "Smith", "password", "jsmith"));
		userList.add(new User("Morty", "Smith", "ihaterick", "msmith"));
		
		io.writeObjects(filename, userList);
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Object files do not like being appended to, you must completely rewrite the file each time you make a change
		userList.add(new User("Rick", "Sanchez", "ilovemorty", "rsanchez"));
		
		io.writeObjects(filename, userList);
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getFirstName().equals("Morty")) {
				userList.get(i).setUsername("mortdawg");
			}
		}
		
		io.writeObjects(filename, userList);
		
		try {
			System.out.println(io.readObjects(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeObjects(String filename, ArrayList<T> objList) {
		//try with resources
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));){
			out.writeObject(objList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<T> readObjects(String filename) throws IOException, FileNotFoundException, ClassNotFoundException {
		ArrayList<T> ret;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		ret = (ArrayList<T>) in.readObject();
		return ret;
	}
	
}
