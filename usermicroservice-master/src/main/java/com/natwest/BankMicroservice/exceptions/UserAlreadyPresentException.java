package com.natwest.BankMicroservice.exceptions;

public class UserAlreadyPresentException  extends Exception{
	public UserAlreadyPresentException(String msg) {
		super(msg);
	}
}
