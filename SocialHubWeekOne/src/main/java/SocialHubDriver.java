import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.UserService;

public class SocialHubDriver {
	
	private static UserService uServ = new UserService("users.txt");
	//file for posts
	private static UserService uServPosts = new UserService("posts.txt");
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

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
						
						//make post an option
						System.out.println("Post or Browse? Press 1 to Post, Press 2 to Browse");
						int choice2 = Integer.parseInt(in.nextLine());
						
						if(choice2==1)
						{
							System.out.println("What is the title of your post?");
							String title = in.nextLine();
							System.out.println("What is the content?");
							String content = in.nextLine();
							//username stored in String "username"
							
							//make instance of post to store users post
							Post userPost = new Post(title, content, username);
							//push it to the file "posts.txt"
						    uServPosts.post(userPost);
						    System.out.println("Congratulations you made a new post :)");
							
						}
						else if(choice2 == 2)
						{
							FileIO postsFile = new FileIO(uServPosts.getFile());
							System.out.println(postsFile.readObjects());
						}
						else 
						{
							System.out.println("Wrong input");
						}
						
						
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
