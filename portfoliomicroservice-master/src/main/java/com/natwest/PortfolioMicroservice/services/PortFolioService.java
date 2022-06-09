package com.natwest.PortfolioMicroservice.services;

import java.util.List;
import java.util.Map;

import com.natwest.PortfolioMicroservice.exceptions.NotEnoughStocksToSellException;
import com.natwest.PortfolioMicroservice.exceptions.PortFolioAlreadyPresentException;
import com.natwest.PortfolioMicroservice.exceptions.PortFolioNotPresentException;
import com.natwest.PortfolioMicroservice.exceptions.TradeOperationNotAllowedException;
import com.natwest.PortfolioMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.PortfolioMicroservice.exceptions.UserNotPresentException;
import com.natwest.PortfolioMicroservice.model.PortFolio;
import com.natwest.PortfolioMicroservice.model.Trade;
import com.natwest.PortfolioMicroservice.model.User;

public interface PortFolioService {
	// User Operations
		User addUser(User usrObj) throws UserAlreadyPresentException;	
		List<User> viewUsers();
		User updateUser(User userObj);
		public void deleteUser(String userId) throws UserNotPresentException;

		// PortFolio related operations
		public PortFolio createPortfolio(PortFolio portfolio, String userId) throws PortFolioAlreadyPresentException, UserNotPresentException;
		public List<PortFolio> viewAllPortFolios(String userid) throws UserNotPresentException;
		public boolean deletePortfolio(String userid, String portName) throws UserNotPresentException, PortFolioNotPresentException;
		public Map<String,Integer> getstocksOfPortfolio(String userId, String portName) throws UserNotPresentException, PortFolioNotPresentException;
		public PortFolio viewPortFolio(String userId, String portName) throws UserNotPresentException, PortFolioNotPresentException;
		// Trade related operations
		public List<Trade> getTrades(String userId, String portName) throws UserNotPresentException, PortFolioNotPresentException;
		public Trade tradeStocks(String userId, String portName, Trade trade) throws UserNotPresentException, PortFolioNotPresentException, NotEnoughStocksToSellException, TradeOperationNotAllowedException;
}
