package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.models.User;
import com.example.utils.HibernateUtil;

public class UserDaoHibernate implements UserDao{
	
	
	//Native SQL will allow use to execute place old SQL queries on the table itself
	//It is not recommened because this tightly couples your code to the database itself
	@Override
	public List<User> getAllUsers() {
		
		//Step one get the session
		Session ses = HibernateUtil.getSession();
		
		//Step two create the query
		List<User> users = ses.createNativeQuery("select * from users", User.class).list();
		
		return users;
	}
	
	//HQL allows you to create queries based on the object rather than the table
	@Override
	public User getUserByUsername(String username) {
		
		Session ses = HibernateUtil.getSession();
		
		User user = ses.createQuery("from User where username=:username", User.class).setString("username", username).uniqueResult();
		return user;
		
	}

	@Override
	public void createUser(User u) throws SQLException {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		
		//Use the .save() method on the session object to save the user to database, then commit the transaction
		ses.save(u);
		tran.commit();
	}

	@Override
	public void updateUser(User u) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		
		ses.update(u);
		tran.commit();
	}

	@Override
	public void deleteUser(User u) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		
		ses.delete(u);
		tran.commit();
		
	}

}
