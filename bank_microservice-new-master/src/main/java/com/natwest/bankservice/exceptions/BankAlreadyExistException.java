package com.natwest.bankservice.exceptions;

@SuppressWarnings("serial")
public class BankAlreadyExistException extends Exception
{
	public BankAlreadyExistException(String message) 
	{
		super(message);
	}

}
