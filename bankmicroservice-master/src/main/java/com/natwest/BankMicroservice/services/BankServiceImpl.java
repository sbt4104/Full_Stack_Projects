package com.natwest.BankMicroservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.BankMicroservice.exceptions.BankAccountAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.BankNotPresentException;
import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.UserNotPresentException;
import com.natwest.BankMicroservice.model.Bank;
import com.natwest.BankMicroservice.model.User;
import com.natwest.BankMicroservice.repository.BankRepo;
import com.natwest.BankMicroservice.repository.UserRepo;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankRepo bankrepo;

	@Autowired
	UserRepo userrepo;

	@Override
	public Bank addBank(Bank bankObj, String userId) throws BankAccountAlreadyPresentException, UserNotPresentException {
		Optional<User> useropt= userrepo.findById(userId);
		
		if(useropt.isPresent())
		{
			User currUser = useropt.get();
			Optional<Bank> bankopt= bankrepo.findById(bankObj.getAccountNumber());
			
			if(currUser.getBank() != null) {
				throw new BankAccountAlreadyPresentException("User already has a bank account, use update end point to update");
			} else if(bankopt.isPresent()) {
				throw new BankAccountAlreadyPresentException("Bank Acount number already belongs to someone else");
			}
			else {
				bankObj.setUser(currUser.getUserid());
				bankrepo.save(bankObj);
			
				currUser.setBank(bankObj);
				userrepo.save(currUser);
				return bankObj;
			}
		} else {
			throw new UserNotPresentException("User not present");
		}
	}


	@Override
	public Bank updateBank(Bank bankObj, String userId) throws UserNotPresentException {
		Optional<User> useropt= userrepo.findById(userId);

		if(useropt.isPresent())
		{
			User currUser = useropt.get();
			
			// remove the already present present account
			if(currUser.getBank() != null && currUser.getBank().getAccountNumber() != bankObj.getAccountNumber()) {
				bankrepo.deleteById(currUser.getBank().getAccountNumber());
			}

			currUser.setBank(bankObj);
			bankObj.setUser(userId);
			bankrepo.save(bankObj);
		
			currUser.setBank(bankObj);
			userrepo.save(currUser);
			return bankObj;
		} else {
			throw new UserNotPresentException("User not present");
		}
	}

	@Override
	public void deleteBank(String userId) throws UserNotPresentException, BankNotPresentException {
		Optional<User> useropt= userrepo.findById(userId);

		if(useropt.isPresent())
		{
			User currUser = useropt.get();
			Bank currBank = currUser.getBank();
			if(currBank == null) {
				throw new BankNotPresentException("Bank is already deleted");
			}
			// delete bank from Bank Table
			bankrepo.deleteById(currBank.getAccountNumber());

			// set Bank to null in details
			currUser.setBank(null);
			userrepo.save(currUser);
		} else {
			throw new UserNotPresentException("User not present");
		}
	}

	@Override
	public User addUser(User usrObj) throws UserAlreadyPresentException {
		Optional<User> useropt= userrepo.findById(usrObj.getUserid());
		
		if(useropt.isPresent())
		{		    	
			throw new UserAlreadyPresentException("User Already present");
		}
		else {
			userrepo.save(usrObj);
			return usrObj;
		}
	}

	@Override
	public List<User> viewUsers() {
		return userrepo.findAll();
	}

	@Override
	public User updateUser(User userObj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteUser(String userId) throws UserNotPresentException {
		Optional<User> useropt= userrepo.findById(userId);
		
		if(useropt.isPresent())
		{		    	
			User currUser = useropt.get();
			Bank currBank = currUser.getBank();
			if(currBank != null) {
				// delete bank from Bank Table
				bankrepo.deleteById(currBank.getAccountNumber());
			}
			// delete user
			userrepo.deleteById(userId);
		}
		else {
			throw new UserNotPresentException("User not present");
		}
	}
}
