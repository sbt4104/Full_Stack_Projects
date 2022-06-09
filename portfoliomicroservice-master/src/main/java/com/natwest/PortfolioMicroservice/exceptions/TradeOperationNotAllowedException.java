package com.natwest.PortfolioMicroservice.exceptions;

public class TradeOperationNotAllowedException extends Exception{
	public TradeOperationNotAllowedException(String msg) {
		super(msg);
	}
}
