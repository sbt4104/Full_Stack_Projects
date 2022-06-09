package com.natwest.authorise.service;

import com.natwest.authorise.Exceptions.UserAlreadyExists;
import com.natwest.authorise.model.Userprofile;

public interface UserService 
{
	Userprofile addCustomer(Userprofile user) throws UserAlreadyExists;
	
	boolean validate(String userid,String password);


}
