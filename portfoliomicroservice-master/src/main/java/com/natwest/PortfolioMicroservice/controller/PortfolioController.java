package com.natwest.PortfolioMicroservice.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.PortfolioMicroservice.exceptions.NotEnoughStocksToSellException;
import com.natwest.PortfolioMicroservice.exceptions.PortFolioAlreadyPresentException;
import com.natwest.PortfolioMicroservice.exceptions.PortFolioNotPresentException;
import com.natwest.PortfolioMicroservice.exceptions.TradeOperationNotAllowedException;
import com.natwest.PortfolioMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.PortfolioMicroservice.exceptions.UserNotPresentException;
import com.natwest.PortfolioMicroservice.model.Bank;
import com.natwest.PortfolioMicroservice.model.PortFolio;
import com.natwest.PortfolioMicroservice.model.Trade;
import com.natwest.PortfolioMicroservice.model.User;
import com.natwest.PortfolioMicroservice.services.PortFolioService;

@RestController
@CrossOrigin
@RequestMapping("/api/portfolio")
public class PortfolioController {
	@Autowired
	PortFolioService portfolioservice;

	@PostMapping("/createportfolio/{userid}")
	public ResponseEntity createPortfolio(@RequestBody PortFolio portfolio, @PathVariable("userid") String userId)
	{
		try {
			portfolioservice.createPortfolio(portfolio, userId);
		} catch (PortFolioAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);	
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<PortFolio>(portfolio,HttpStatus.CREATED);
	}

	@GetMapping("/viewallportfolios/{userid}")
	public ResponseEntity viewPortfolios(@PathVariable("userid") String userId)
	{
		List<PortFolio> portfolioList;
		try {
			portfolioList = portfolioservice.viewAllPortFolios(userId);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		 return new ResponseEntity<List>(portfolioList,HttpStatus.OK);
	}

	@GetMapping("/getTrades/{userid}/{portname}")
	public ResponseEntity getTrades(@PathVariable("userid") String userId, @PathVariable("portname") String portName)
	{
		List<Trade> trades;
		try {
			trades = portfolioservice.getTrades(userId, portName);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (PortFolioNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<List>(trades,HttpStatus.OK);
	}

	@GetMapping("/getportfolio/{userid}/{portname}")
	public ResponseEntity getPortfolio(@PathVariable("userid") String userId, @PathVariable("portname") String portName)
	{
		PortFolio currPortFolio = new PortFolio();
		try {
			currPortFolio = portfolioservice.viewPortFolio(userId, portName);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (PortFolioNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<PortFolio>(currPortFolio,HttpStatus.OK);
	}

	@GetMapping("/getStocks/{userid}/{portname}")
	public ResponseEntity getStocksOfPortfolios(@PathVariable("userid") String userId,  @PathVariable("portname") String portName)
	{
		Map<String, Integer> stockMap = new TreeMap<String, Integer>();
		try {
			stockMap = portfolioservice.getstocksOfPortfolio(userId, portName);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (PortFolioNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		 return new ResponseEntity<Map>(stockMap,HttpStatus.OK);
	}

	@DeleteMapping("/deleteportfolio/{userid}/{portname}")
	public ResponseEntity deletePortfolio(@PathVariable("userid") String userId, @PathVariable("portname") String portName)
	{
		try {
			portfolioservice.deletePortfolio(userId, portName);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (PortFolioNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}

	@PostMapping("/tradeStocks/{userid}/{portname}")
	public ResponseEntity deletePortfolio(@PathVariable("userid") String userId, @PathVariable("portname") String portName, @RequestBody Trade trade)
	{
		Trade currTrade = new Trade();
		try {
			currTrade = portfolioservice.tradeStocks(userId, portName, trade);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (PortFolioNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (NotEnoughStocksToSellException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (TradeOperationNotAllowedException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Trade>(currTrade,HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity saveuser(@RequestBody User usernew)
	{
		User userObj;
		try {
			userObj = portfolioservice.addUser(usernew);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(usernew,HttpStatus.CREATED);	
	}

	@GetMapping("/viewallusers")
	public ResponseEntity viewusers()
	{
		 List<User> users = portfolioservice.viewUsers();
		 return new ResponseEntity<List>(users,HttpStatus.OK);
	}

	@PostMapping("/deleteUser/{userid}")
	public ResponseEntity deleteUser(@PathVariable("userid") String userId)
	{
		try {
			portfolioservice.deleteUser(userId);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("User Deleted successfully",HttpStatus.OK);
	}
}