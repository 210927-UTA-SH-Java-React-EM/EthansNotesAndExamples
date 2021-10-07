import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.example.dao.PostDao;
import com.example.dao.PostDaoDB;
import com.example.dao.UserDao;
import com.example.dao.UserDaoDB;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static PostDao pDao = new PostDaoDB();
	private static PostService pServ = new PostService(pDao);
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//This will be used to control our loop
		boolean done = false;
		
		User u = null;
		
		while(!done) {
			
			if(u == null) {
				System.out.println("Login or Signup? Press 1 to login, press 2 to signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter you password: ");
					String password = in.nextLine();
					
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getUsername());
					} catch(Exception e) {
						System.out.println("Username or password was incorrect, guess wrong again and you get pushed into the pit of misery");
					}
				} else {
					System.out.print("Please enter you first name: ");
					String first = in.nextLine();
					System.out.print("Please enter your last name: ");
					String last = in.nextLine();
					System.out.print("Please enter you email: ");
					String email = in.nextLine();
					System.out.print("Please enter you username: ");
					String username = in.nextLine();
					System.out.print("Please enter you password: ");
					String password = in.nextLine();
					
					try {
						u = uServ.signUp(first, last, email, username, password);
						System.out.println("You may now sign in with the username: " + u.getUsername());
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Sorry the username is already taken");
						System.out.println("Please try signing up with a different one");
					}
				}
			} else {
				System.out.println("To view posts press 1, to create a post press 2");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					//Do some logic to view the post
				}
				else {
					//Ask them for input, and create the post
					System.out.println("Please speak your mind below:");
					String content = in.nextLine();
					pServ.addPost(u.getId(), u.getId(), content);
					System.out.println("Post was received, are you finished? Press 1 for yes, 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				}
			}
			
		}
		
		System.out.println("Goodbye :)");
		in.close();
		
		/*
		List<User> uList = uDao.getAllUsers();
		
		System.out.println(uList);
		
		User morty = uDao.getUserByUsername("mortysmith");
		
		System.out.println(morty);
		
		User gearhead = new User("Bird", "Person", "birdperson@mail.com", "birdperson", "password");
		
		try {
			uDao.createUser(gearhead);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		uList = uDao.getAllUsers();
		System.out.println(uList);
		
		morty.setEmail("newMail@mail.com");
		morty.setUsername("mortdawg1738");
		
		uDao.updateUser(morty);
		
		uDao.getUserByUsername("mortdawg1738");
		System.out.println(morty);
		
		User birdPerson = uDao.getUserByUsername("birdperson");
		uDao.deleteUser(birdPerson);
		uList = uDao.getAllUsers();
		System.out.println(uList);
		*/
	}

}
