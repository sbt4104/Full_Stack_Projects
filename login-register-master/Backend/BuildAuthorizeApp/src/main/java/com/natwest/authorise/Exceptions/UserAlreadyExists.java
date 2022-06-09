package com.natwest.authorise.Exceptions;

public class UserAlreadyExists extends Exception{
	public UserAlreadyExists()
	{
		super("User Already Exists");
	}
}
