package com.example.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Collections {

	public static void main(String[] args) {
		
		User u1 = new User("Summer", "Smith", "sssumertime", "ssmith");
		User u2 = new User("Jerry", "Smith", "password", "jsmith");
		User u3 = new User("Rick", "Sanchez", "ilovemorty", "rsanchez");
		User u4 = new User("Morty", "Smith", "ihaterick", "msmith");
		
		//Lists
		List<User> userArrayList = new ArrayList<User>();
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		//To add users to the arraylist
		userArrayList.add(u1);
		userArrayList.add(u2);
		userArrayList.add(u3);
		
		//You can use these just like arrays
		System.out.println("Regular old for loop with ArrayList");
		for(int i=0; i<userArrayList.size(); i++) {
			System.out.println(userArrayList.get(i));
		}
		System.out.println("-------------------------");
		
		//LinkedList and iterators
		List<User> userLinkedList = new LinkedList<User>();
		
		userLinkedList.add(u1);
		userLinkedList.add(u2);
		userLinkedList.add(u3);
		
		Iterator<User> linkedListIterator = userLinkedList.iterator();
		
		System.out.println("Iterating through the linked list with our iterator");
		while(linkedListIterator.hasNext()) {
			System.out.println(linkedListIterator.next());
		}
		System.out.println("-------------------------");
		
		//Sets
		Set<User> userSet = new HashSet<User>();
		
		//Sets cannot contain duplicates
		userSet.add(u1);
		userSet.add(u1);
		
		userSet.add(u2);
		userSet.add(u3);
		userSet.add(u4);
		
		//You can still loop through a set
		System.out.println("Looping through a set");
		for(User u: userSet) {
			System.out.println(u);
		}
		System.out.println("-------------------------");
		
		//Queue and Deque
		ArrayDeque<User> userQueue = new ArrayDeque<User>();
		
		//To add users to the front of the queue use push
		userQueue.push(u1);
		System.out.println(userQueue);
		//To add user to the end of the queue use add
		userQueue.add(u2);
		System.out.println(userQueue);
		userQueue.push(u3);
		userQueue.add(u4);
		System.out.println(userQueue);
		
		//We use .pop() to grab the element at the front of the queue
		User rick = userQueue.pop();
		System.out.println(rick);
		
		User morty = userQueue.removeLast();
		System.out.println(morty);
		System.out.println(userQueue);
		System.out.println("-------------------------");
		
		//Maps
		
		Map<String, User> userMap = new HashMap<String, User>();
		
		//Use .put() to insert into a map
		userMap.put("rick", rick);
		userMap.put("morty", morty);
		userMap.put("summer", u1);
		
		//Use .get(key) to retrieve an element by key
		System.out.println(userMap.get("summer"));
		
		//You cannot iterate over a map directly, but you can iterate over the entrySet, keySet and values
		Iterator<User> mapValues = userMap.values().iterator();
		
		while(mapValues.hasNext()) {
			System.out.println(mapValues.next());
		}
		System.out.println("-------------------------");
		
		//The Collections class has useful methods we can use on collections, including sort
		//In order for the Collections.sort to work, the object being sorted must implement comparable
		java.util.Collections.sort(userArrayList);
		System.out.println(userArrayList);
		System.out.println("-------------------------");
		
		//TreeSets will sort the elements based on a comparator
		Set<User> userTree = new TreeSet<User>(new UserComparator());
		userTree.add(u1);
		userTree.add(u2);
		userTree.add(u3);
		userTree.add(u4);
		
		System.out.println(userTree);
		
	}

}
