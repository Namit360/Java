package com.spring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.model.User;
import com.spring.repository.UserRepo;

public class UserServiceImp implements UserServices
{
	@Autowired
	UserRepo userRepo;

	@Override
	public void addUser(User user) 
	{
		userRepo.save(user);
	}

	@Override
	public List<User> fetchAllUsers()
	{
		List<User> user = userRepo.findAll();
		return user;
	}

	@Override
	public User fetchById(int id)
	{
		User user = userRepo.getById(id);
		return user;
	}
}