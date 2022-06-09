package com.natwest.bankservice.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception
{
	public UserAlreadyExistException (String message)
	{
		super(message);
	}

}
