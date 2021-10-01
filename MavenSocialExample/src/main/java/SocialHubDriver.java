import java.util.ArrayList;
import java.util.Scanner;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.example.services.UserService;

public class SocialHubDriver {

	private static UserService uServ = new UserService("users.txt");
	private static PostService pServ = new PostService("posts.txt");
	private static Scanner scanner = new Scanner(System.in);

	public static User signUp() {
		System.out.print("First name: ");
		String first = scanner.nextLine();

		System.out.print("Last name: ");
		String last = scanner.nextLine();

		System.out.print("Username: ");
		String user = scanner.nextLine();

		System.out.print("Password: ");
		String pass = scanner.nextLine();

		try {
			return uServ.signUp(first, last, user, pass);
		} catch (Exception e) {
			System.out.println("Could not process your request. Please try again later.");
			return null;
		}

	}
	
	public static User logIn() {

		System.out.print("Username: ");
		String user = scanner.nextLine();

		System.out.print("Password: ");
		String pass = scanner.nextLine();

		try {
			return uServ.logIn(user, pass);
		} catch (InvalidCredentialsException e) {
			System.out.println("Username or password was incorrect.");
			return null;
		}
	}

	public static void main(String[] args) {
		String input = "";
		String[] formattedInput;
		boolean done = false;
		User currentUser = null;
		ArrayList<Post> posts;

		while (!input.equals("exit")) {
			if (currentUser == null) {
				System.out.print("Sign up (S) or Log in (L): ");
				char ans = scanner.nextLine().toUpperCase().charAt(0);

				if (ans == 'S') {
					currentUser = signUp();
					System.out.println("Account created.");
				} else if (ans == 'L') {
					currentUser = logIn();
					if (currentUser == null)
						break;
				} else {
					System.out.println("Error: invalid command.");
					continue;
				}
			}
			System.out.println("Type 'posts' (username) to see a user's posts, 'newPost' to create a new post, or 'exit' to leave.");
			System.out.print("Social Hub > ");
			input = scanner.nextLine();
			formattedInput = input.split(" ");
			
			if (formattedInput[0].equals("posts")) {
				if (formattedInput.length == 1)
					posts = pServ.retrievePosts(currentUser.getUsername());
				else posts = pServ.retrievePosts(formattedInput[1]);
				
				if (posts.size() == 0)
					System.out.println("No posts to display.");
				
				else for (Post post : posts) {
					System.out.println(post.toString());
				}
				
			} else if (formattedInput[0].equals("newPost")) {
				System.out.print("Post title: ");
				String title = scanner.nextLine();
				
				System.out.print("Content: ");
				String content = scanner.nextLine();
				
				Post post = pServ.createPost(title, content, currentUser.getUsername());
				if (post == null) {
					System.out.println("Error: Post could not be created.");
				} else System.out.println("Post successfully created.");
			}
		}
		
		System.out.println("Goodbye!");
	}

}
