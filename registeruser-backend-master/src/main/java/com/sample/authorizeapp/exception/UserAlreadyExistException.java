package com.sample.authorizeapp.exception;

public class UserAlreadyExistException extends Exception {
	
	public UserAlreadyExistException(String msg)
	{
		super(msg);
	}

}
