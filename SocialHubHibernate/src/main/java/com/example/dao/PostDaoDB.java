package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Post;
import com.example.models.PostDisplay;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class PostDaoDB implements PostDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	//Use stored procedures and functions
	
	@Override
	public void createPost(Post p) {
		
		try {
			Connection con = conUtil.getConnection();
			
			//We first need to set autocommit to false
			con.setAutoCommit(false);
			String sql = "call create_post(?,?,?)";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, p.getAuthorId());
			cs.setInt(2, p.getWallId());
			cs.setString(3, p.getPostContent());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PostDisplay> getAllPosts() {
		
		List<PostDisplay> pList = new ArrayList<PostDisplay>(); 
		
		try {
			
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			
			//Use this syntax for a stored function
			String sql = "{?=call get_all_posts()}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				//Result set is based on the return from the function, it returns username, postID, authorID, wallID, content in that order
				PostDisplay post = new PostDisplay(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				pList.add(post);
			}
			
			con.setAutoCommit(true);
			return pList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserPosts(User u) {
		
		List<Post> posts = new ArrayList<Post>();
		
		try {
			
			Connection con = conUtil.getConnection();
			
			con.setAutoCommit(false);
			
			String sql = "{?=call get_user_posts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, u.getId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Post p = new Post(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				posts.add(p);
			}
			
			u.setPosts(posts);
			
			con.setAutoCommit(true);
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}