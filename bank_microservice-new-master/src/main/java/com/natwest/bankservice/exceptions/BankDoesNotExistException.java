package com.natwest.bankservice.exceptions;

@SuppressWarnings("serial")
public class BankDoesNotExistException extends Exception
{
	public BankDoesNotExistException (String message)
	{
		super(message);
	}

}
