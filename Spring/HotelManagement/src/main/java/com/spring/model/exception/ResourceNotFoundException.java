package com.spring.model.exception;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}