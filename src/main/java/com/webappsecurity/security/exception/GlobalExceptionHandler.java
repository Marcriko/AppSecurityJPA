package com.webappsecurity.security.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	//Handle specific exceptions
	public ResponseEntity<?> handleResourceNotFoundException
	(ResourceNotFoundException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		return new ResponseEntity(detallesError,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(APIException.class)
	//Handle specific exceptions
	public ResponseEntity<?> handleAPIException
	(APIException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		return new ResponseEntity(detallesError,HttpStatus.NOT_FOUND);
	}
	
	//Handle global exceptions
	@ExceptionHandler(Exception.class)

	public ResponseEntity<?> handleException
	(ResourceNotFoundException resourceNotFoundException, WebRequest request)
	{
		DetallesError detallesError = new DetallesError(new Date() 	,resourceNotFoundException.getMessage(),request.getDescription(false));
		return new ResponseEntity(detallesError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
