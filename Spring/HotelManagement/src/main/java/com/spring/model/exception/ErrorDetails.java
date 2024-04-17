package com.spring.model.exception;

public class ErrorDetails 
{
	private String details;
	private String message;
	
	public ErrorDetails(){}
	
	public ErrorDetails(String details, String message) 
	{
		this.details = details;
		this.message = message;
	}

	public String getDetails() 
	{
		return details;
	}

	public void setDetails(String details) 
	{
		this.details = details;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}
}