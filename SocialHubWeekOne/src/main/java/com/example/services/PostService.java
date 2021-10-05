package com.example.services;

import com.example.dao.FileIO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UsernameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Post;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PostService {
    private String file;
    private FileIO<Post> io;

    public PostService(String file) {
        this.file = file;
        this.io = new FileIO<Post>(file);
    }

    private ArrayList<Post> getPosts()
    {
        ArrayList<Post> posts;

        try {
            posts = io.readObjects();
        } catch(FileNotFoundException e) {
            posts = new ArrayList<Post>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return posts;
    }

    private void printPost(Post p) {
        System.out.println(p);
    }

    public Post createNewPost(String title, String content, String username) {

        ArrayList<Post> posts = getPosts();

        Post post = new Post(title, content, username);

        posts.add(post);
        io.writeObjects(posts);

        System.out.println("Your post was added: ");
        printPost(post);

        return post;
    }

    public void viewPosts() {

        ArrayList<Post> posts = getPosts();

        if (posts.isEmpty())
        {
            System.out.println("No Posts Exist...");
        }
        else
        {
            System.out.println("Existing Posts: ");
            for (Post p : posts) {
                System.out.println("Post: " + p);
            }
        }

    }
}
