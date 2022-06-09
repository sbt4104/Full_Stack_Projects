package com.natwest.PortfolioMicroservice.exceptions;

public class NotEnoughStocksToSellException extends Exception{
	public NotEnoughStocksToSellException(String msg) {
		super(msg);
	}
}
