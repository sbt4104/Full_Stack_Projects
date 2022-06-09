package com.natwest.bankservice.services;

import java.util.List;


import com.natwest.bankservice.exceptions.BankAlreadyExistException;
import com.natwest.bankservice.exceptions.BankDoesNotExistException;
import com.natwest.bankservice.exceptions.UserAlreadyExistException;
import com.natwest.bankservice.exceptions.UserDoesNotExistException;
import com.natwest.bankservice.model.Bank;
import com.natwest.bankservice.model.User;

public interface BankService 
{
	//adding user to check bank functionalities
	public User addUser(User user_obj) throws UserAlreadyExistException;
	public boolean deleteuser(String userid) throws UserDoesNotExistException;
	
	// Bank related operations
	public Bank addBank(Bank bank_obj, String user_id) throws BankAlreadyExistException,UserDoesNotExistException;
	
	public List<Bank> viewBanks(String userid) throws BankDoesNotExistException, UserDoesNotExistException;
	
	
	public Bank updateBank(Bank bank_obj, String user_id) throws BankDoesNotExistException,UserDoesNotExistException;
	
	
	public boolean deleteBank(String userid,String account_number) throws BankDoesNotExistException,UserDoesNotExistException;
	
	public boolean deleteallbank(String userid) throws  UserDoesNotExistException, BankDoesNotExistException;
	
	public boolean makeprimary(String userid,String account_number ) throws BankDoesNotExistException,UserDoesNotExistException;
}
