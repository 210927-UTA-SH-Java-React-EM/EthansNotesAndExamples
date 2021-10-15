
import java.util.List;
import java.util.Scanner;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserService uServ = new UserService("users.txt");
	private static PostService pServ = new PostService("posts.txt");
<<<<<<< HEAD
=======
	
>>>>>>> 8e804db719f7e03609c42aa7ad9f7c4c750a506d
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//This will be used to control our loop
		boolean done = false;
		
		User u = null;
		
		while(!done) {
			if(u == null) {
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to Signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
<<<<<<< HEAD
						u = uServ.login(username, password);
						System.out.println("Welcome " + u.getFirstName());
					} catch(Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
=======
						loggedIn = uServ.login(username, password);
						//
						System.out.println("Press 1 to read all the post, press 2 to write a post:"); 
						int c = Integer.parseInt(in.nextLine());
						if(c == 1)
						{
							for(Post post:pServ.readPosts())
							{
								  
								 if(post.getUser().equalsIgnoreCase(loggedIn.getUsername()))
								 {
							
								System.out.println(post.getTitle()+" "+post.getContent()+" "+post.getUser());
								 }
							}
							
							done = true;
						}
						else
						{
						 
						 System.out.println("Please enter the title");
						 String title = in.nextLine();
						 System.out.println("Please enter the content:");
						 String content = in.nextLine();
						 String user = loggedIn.getUsername();
						 
						pServ.content(title, content, user);
						 for(Post post:pServ.readPosts())
							{
							 	  
							 if(post.getUser().equalsIgnoreCase(loggedIn.getUsername()))
							 {
								 System.out.println(post.getTitle()+" "+post.getContent()+" "+post.getUser());
							 }
							}
					       
						 done = true;
						}
						
						//
					} catch(InvalidCredentialsException e) {
						System.out.println("Username or password incorrect. Goodbye");
>>>>>>> 8e804db719f7e03609c42aa7ad9f7c4c750a506d
						done = true;
					}
				} else {
					System.out.print("Please enter you first name: ");
					String first = in.nextLine();
					System.out.println("Please enter your last name: ");
					String last = in.nextLine();
					System.out.println("Please enter your username");
					String username = in.nextLine();
					System.out.println("Please enter a password: ");
					String password = in.nextLine();
					try {
						u = uServ.signUp(first, last, username, password);
						System.out.println("You may now log in with the username: " + u.getUsername());
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
			} else {
				System.out.println("To view posts press 1, to create a post press 2");
				int choice = Integer.parseInt(in.nextLine());
				//If the user chooses 1, we will show them the list of posts
				if(choice == 1) {
					List<Post> posts = pServ.getAllPosts();
					for(Post post: posts) {
						System.out.println(post.getUser() + ":");
						System.out.println(post.getContent());
						System.out.println();
					}
					System.out.println("Are you finished? Press 1 for yes, press 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				} else {
					System.out.println("Please enter your content below:");
					String content = in.nextLine();
					Post p = new Post(u.getUsername(), content);
					pServ.addPost(p);
					System.out.println("Post was received, are you finished? Press 1 for yes, press 2 for no");
					choice = Integer.parseInt(in.nextLine());
					done = (choice == 1) ? true : false;
				}
			}
		}
		
		System.out.println("Goodbye :)");
		in.close();
	}
	
}
