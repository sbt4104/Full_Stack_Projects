package com.natwest.BankMicroservice.exceptions;

public class BankAccountAlreadyPresentException extends Exception{
	public BankAccountAlreadyPresentException(String msg) {
		super(msg);
	}
}
