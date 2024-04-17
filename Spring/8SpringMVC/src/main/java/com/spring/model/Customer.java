package com.spring.model;

public class Customer 
{
	String username;
	String address;
	
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	@Override
	public String toString() 
	{
		return "Customer [username=" + username + ", address=" + address + "]";
	}
}