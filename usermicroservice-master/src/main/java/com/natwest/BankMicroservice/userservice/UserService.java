package com.natwest.BankMicroservice.userservice;

import java.util.List;

import com.natwest.BankMicroservice.exceptions.UserNotPresentException;
import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;

import com.natwest.BankMicroservice.user.Userprofile;

public interface UserService {

	Userprofile addUser(Userprofile usrObj) throws UserAlreadyPresentException;
	List<Userprofile> viewUsers();
	Userprofile viewbyId(String userId) throws UserNotPresentException;
	Userprofile updateUser(Userprofile usrObj,String uId) throws UserNotPresentException;
	//boolean deleteUser(String userId) throws UserNotPresentException;
}
