package com.natwest.BankMicroservice.services;

import java.util.List;

import com.natwest.BankMicroservice.exceptions.BankAccountAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.BankNotPresentException;
import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.UserNotPresentException;
import com.natwest.BankMicroservice.model.Bank;
import com.natwest.BankMicroservice.model.User;

public interface BankService {
	// User Operations
	User addUser(User usrObj) throws BankAccountAlreadyPresentException, UserAlreadyPresentException;	
	List<User> viewUsers();
	User updateUser(User userObj);
	public void deleteUser(String userId) throws UserNotPresentException;

	// Bank related operations
	public Bank addBank(Bank bankObj, String userId) throws BankAccountAlreadyPresentException, UserNotPresentException;
	public Bank updateBank(Bank bankObj, String userId) throws UserNotPresentException;
	public void deleteBank(String userId) throws UserNotPresentException, BankNotPresentException;
}
