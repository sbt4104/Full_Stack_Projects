package com.natwest.PortfolioMicroservice.exceptions;

public class UserAlreadyPresentException  extends Exception{
	public UserAlreadyPresentException(String msg) {
		super(msg);
	}
}
