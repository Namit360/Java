package com.spring.model.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionalAdder
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest web)
	{
		ErrorDetails errordetails = new ErrorDetails(ex.getMessage(),web.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globallyException(Exception ex, WebRequest web)
	{
		ErrorDetails errordetails = new ErrorDetails(ex.getMessage(),web.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}