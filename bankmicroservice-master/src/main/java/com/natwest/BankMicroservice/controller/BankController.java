package com.natwest.BankMicroservice.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.BankMicroservice.exceptions.BankAccountAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.BankNotPresentException;
import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.UserNotPresentException;
import com.natwest.BankMicroservice.model.Bank;
import com.natwest.BankMicroservice.model.PortFolio;
import com.natwest.BankMicroservice.model.Trade;
import com.natwest.BankMicroservice.model.User;
import com.natwest.BankMicroservice.services.BankService;

@RestController
@CrossOrigin
@RequestMapping("/api/bank")
public class BankController {
	@Autowired
	BankService bankservice;

	@PostMapping("/addbank/{userid}")
	public ResponseEntity addBank(@RequestBody Bank bankObj, @PathVariable("userid") String userId)
	{
		Bank currBank;
		try {
			currBank = bankservice.addBank(bankObj, userId);
		} catch (BankAccountAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Bank>(currBank,HttpStatus.CREATED);	
	}

	@PostMapping("/updateBank/{userid}")
	public ResponseEntity updateBank(@RequestBody Bank bankupd, @PathVariable("userid") String userId)
	{
		try {
			bankservice.updateBank(bankupd, userId);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<Bank>(bankupd,HttpStatus.CREATED);
	}

	@PostMapping("/deleteBank/{userid}")
	public ResponseEntity deleteBank(@PathVariable("userid") String userId)
	{
		
		try {
			bankservice.deleteBank(userId);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (BankNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity saveuser(@RequestBody User usernew)
	{
		User userObj;
		try {
			userObj = bankservice.addUser(usernew);
		} catch (BankAccountAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(usernew,HttpStatus.CREATED);	
	}
	
	@GetMapping("/viewallusers")
	public ResponseEntity viewusers()
	{
		 List<User> users = bankservice.viewUsers();
		 return new ResponseEntity<List>(users,HttpStatus.OK);
	}
	
	@PostMapping("/deleteUser/{userid}")
	public ResponseEntity deleteUser(@PathVariable("userid") String userId)
	{
		
		try {
			bankservice.deleteUser(userId);
		} catch (UserNotPresentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("User Deleted successfully",HttpStatus.OK);
	}
}
