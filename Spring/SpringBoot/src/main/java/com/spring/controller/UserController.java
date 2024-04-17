package com.spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.User;
import com.spring.service.UserServices;

@RestController
@RequestMapping("/v1")
public class UserController 
{
	@Autowired
	UserServices userservice;
	
	@RequestMapping("/load")
	public String loadUser()
	{
		return "loading...";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public void addUserInfo(@RequestBody User user)
	{
		userservice.addUser(user);
	}
	
	@RequestMapping("/user")
	public List<User> getAllUsers()
	{
		List<User> user = userservice.fetchAllUsers();
		return user;
	}
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id)
	{
		User user = userservice.fetchById(id);
		return user;
	}
}