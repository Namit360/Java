package com.spring.service;
import java.util.List;
import com.spring.model.User;

public interface UserServices 
{
	public void addUser(User user);
	public List<User> fetchAllUsers();
	public User fetchById(int id);
}