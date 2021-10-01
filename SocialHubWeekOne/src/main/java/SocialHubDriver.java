import java.util.Scanner;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserService uServ = new UserService("users.txt");
	private static PostService pServ = new PostService("posts.txt");
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		
		User loggedIn = null;
		
		while(!done) {
			
			if(loggedIn == null) {
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to SignUp");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						loggedIn = uServ.login(username, password);
						//
						System.out.println("Press 1 to read all the post, press 2 to write a post:"); 
						int c = Integer.parseInt(in.nextLine());
						if(c == 1)
						{
							for(Post post:pServ.readPosts())
							{
								System.out.println(post.getTitle()+"--"+post.getContent()+" "+post.getUser());
							}
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
								System.out.println(post.getTitle()+"--"+post.getContent()+" "+post.getUser());
							}
					       
						 done = true;
						}
						
						//
					} catch(InvalidCredentialsException e) {
						System.out.println("Username or password incorrect. Goodbye");
						done = true;
					}
					continue;
				}
				else {
					System.out.print("Please enter your first name: ");
					String first = in.nextLine();
					System.out.print("Please enter your last name: ");
					String last = in.nextLine();
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					
					try {
						loggedIn = uServ.signUp(first, last, username, password);
						System.out.println("You may now login with the username: " + loggedIn.getUsername());
						loggedIn = null;
						continue;
					} catch (Exception e) {
						System.out.println("Sorry we could not process your request");
						System.out.println("Please try again later");
						continue;
					}
				}
			}
			
		}

	}

}
