package com.natwest.BankMicroservice.userservice;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.UserNotPresentException;

import com.natwest.BankMicroservice.user.Userprofile;
import com.natwest.BankMicroservice.userrepo.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userrepo;
	
	@Override
	public Userprofile addUser(Userprofile usrObj) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		
		Optional<Userprofile> useropt= userrepo.findById(usrObj.getUserId());
		
		if(useropt.isPresent())
		{		    	
			throw new UserAlreadyPresentException("User is Already present");
		} else {
			userrepo.saveAndFlush(usrObj);
			return usrObj;
		}
	}



	@Override
	public List<Userprofile> viewUsers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public Userprofile viewbyId(String userId) throws UserNotPresentException {
		// TODO Auto-generated method stub
		Optional<Userprofile> userbyid=userrepo.findById(userId);
		if(!userbyid.isPresent())
			throw new UserNotPresentException("The UserId you entered does not exist");
		return userbyid.get();
			
	}

	@Override
	public Userprofile updateUser(Userprofile usrObj,String uId) throws UserNotPresentException {
		// TODO Auto-generated method stub
		Optional<Userprofile> us=userrepo.findById(uId);
		if(us.isPresent()) {
			Userprofile newUser=us.get();
			newUser.setFirstName(usrObj.getFirstName());
			newUser.setLastName(usrObj.getLastName());
			newUser.setMobileNumber(usrObj.getMobileNumber());
			newUser.setPassword(usrObj.getPassword());
			userrepo.save(newUser);
			return usrObj;
		} else {
			throw new UserNotPresentException("User you want to update does not exist");
		}
	}

	/*@Override
	public boolean deleteUser(String userId) throws UserNotPresentException {
		// TODO Auto-generated method stub
		
		return false;
	}*/

}
