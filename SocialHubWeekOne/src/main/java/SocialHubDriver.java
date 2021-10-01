import java.util.Scanner;

import com.example.exceptions.InvalidCredentialsException;
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


			/*******************************************************
								post or not
			 *******************************************************/
			//Prompt for posts
			System.out.println("Creat a Post, View Posts, or Exit? Press 1 to Create a Post, " +
					"Press 2 to View Posts, or Press 3 to exit");
			int choice = Integer.parseInt(in.nextLine());

			switch(choice)
			{
				case 1:
					System.out.println("Create a Post");
					// get info
					System.out.print("Please enter the title of the Post: ");
					String title = in.nextLine();
					System.out.print("Please enter the content of the post: ");
					String content = in.nextLine();
					// save info
					pServ.createNewPost(title, content, loggedIn.getUsername());
					break;
				case 2:
					System.out.println("View Posts");
					pServ.viewPosts();
					break;
				case 3:
					System.out.println("Exit");
					done = true;
					break;
				default: break;
			}
			
		}

	}

}
