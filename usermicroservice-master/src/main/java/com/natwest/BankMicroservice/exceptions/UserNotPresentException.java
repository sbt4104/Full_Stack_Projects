package com.natwest.BankMicroservice.exceptions;

public class UserNotPresentException extends Exception{
	public UserNotPresentException(String msg) {
		super(msg);
	}

}
