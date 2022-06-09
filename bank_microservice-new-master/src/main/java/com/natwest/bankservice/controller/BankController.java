package com.natwest.bankservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.bankservice.exceptions.BankAlreadyExistException;
import com.natwest.bankservice.exceptions.BankDoesNotExistException;
import com.natwest.bankservice.exceptions.UserAlreadyExistException;
import com.natwest.bankservice.exceptions.UserDoesNotExistException;
import com.natwest.bankservice.model.Bank;
import com.natwest.bankservice.model.User;
import com.natwest.bankservice.services.BankService;



@RestController
@CrossOrigin
@RequestMapping("/api/bank") //common mapping
public class BankController 
{
	@Autowired
	BankService bank_service;

	@SuppressWarnings("rawtypes")
	@PostMapping("/adduser")
	public ResponseEntity saveuser(@RequestBody User user)
	{
		User user_obj;
		try 
		{
			user_obj = bank_service.addUser(user);
		} 
		
		catch (UserAlreadyExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<User>(user_obj,HttpStatus.CREATED);	
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/addbank/{userid}")
	public ResponseEntity saveBank(@RequestBody Bank bank,@PathVariable("userid") String userid)
	{
		Bank bank_obj;
		try 
		{
			bank_obj = bank_service.addBank(bank, userid);
		} 
		
		catch (BankAlreadyExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		} 
		
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Bank>(bank_obj,HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/viewbanks/{userid}")
	public ResponseEntity viewBanks(@PathVariable("userid") String userid)
	{
		List<Bank> bank_ls;
		try 
		{
			bank_ls = bank_service.viewBanks(userid);
		} 
		catch (BankDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<List<Bank>>(bank_ls,HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/updatebank/{userid}")
	public ResponseEntity updateBank(@RequestBody Bank bank_obj, @PathVariable("userid") String userid)
	{
		Bank bank_upd;
		try {
			bank_upd=bank_service.updateBank(bank_obj, userid);
			
		} 
		catch (BankDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<Bank>(bank_upd,HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deletebank/{account_number}/{userid}")
	public ResponseEntity deleteBank(@PathVariable("account_number") String account_number,@PathVariable("userid") String userid)
	{
		try 
		{
			
			bank_service.deleteBank(userid, account_number);
			
		} 
		catch (BankDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<String>("Succesfully get deleted ",HttpStatus.CREATED);
	}
	
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deleteAllbanks/{userid}")
	public ResponseEntity deleteAllBanks(@PathVariable("userid") String userid)
	{
		try 
		{
			
			bank_service.deleteallbank(userid);
			
		} 
		catch (BankDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<String>("Succesfully get deleted ",HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deleteuser/{userid}")
	public ResponseEntity deleteuser(@PathVariable("userid") String userid)
	{
		try 
		{
			bank_service.deleteuser(userid);
		} 
	
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<String>("Succesfully get deleted ",HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/makeprimary/{account_number}/{userid}")
	public ResponseEntity MakeBankPrimary(@PathVariable("account_number") String account_number,@PathVariable("userid") String userid)
	{
		try 
		{
			
			bank_service.makeprimary(userid, account_number);
			
		} 
		catch (BankDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		catch (UserDoesNotExistException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	
		return new ResponseEntity<String>("You made this account as your primary one",HttpStatus.CREATED);
	}
	

	


}
