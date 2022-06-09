package com.natwest.PortfolioMicroservice.exceptions;

public class PortFolioAlreadyPresentException extends Exception{
	public PortFolioAlreadyPresentException(String msg) {
		super(msg);
	}

}
