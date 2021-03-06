package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	public User findByUsername(String username);
	
}
