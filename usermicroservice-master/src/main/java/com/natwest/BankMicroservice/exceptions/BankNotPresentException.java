package com.natwest.BankMicroservice.exceptions;

public class BankNotPresentException extends Exception{
	public BankNotPresentException(String msg) {
		super(msg);
	}
}
