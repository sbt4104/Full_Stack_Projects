package com.natwest.PortfolioMicroservice.exceptions;

public class UserNotPresentException extends Exception{
	public UserNotPresentException(String msg) {
		super(msg);
	}

}
