package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.utils.HibernateUtil;

public class PostDaoHibernate implements PostDao{

	@Override
	public void createPost(Post p) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		ses.save(p);
		tran.commit();
		
	}

	@Override
	public List<PostDisplay> getAllPosts() {
		
		Session ses = HibernateUtil.getSession();
		
		//Use HQL to get posts, and order them by postId
		List<Post> posts = ses.createQuery("from Post ORDER BY postId DESC", Post.class).list();
		
		List<PostDisplay> postList = new ArrayList<PostDisplay>();
		
		for(Post post: posts) {
			PostDisplay p = new PostDisplay(post.getUser().getUsername(), post.getPostId(), post.getUser().getId(), post.getUser().getId(), post.getPostContent());
			postList.add(p);
		}
		
		return postList;
	}
	
	public Post getPostById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Post p = ses.createQuery("from Post where id=:id", Post.class).setInteger("id", id).uniqueResult();
		
		return p;
	}
	
	//This method is unneeded, because hibernate will automatically link the user to the post
	@Override
	public User getUserPosts(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Post updatePost(Post p) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		ses.update(p);
		tran.commit();
		
		return p;
	}

}
