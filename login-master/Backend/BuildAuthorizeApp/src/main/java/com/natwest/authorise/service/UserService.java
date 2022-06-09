package com.natwest.authorise.service;

import com.natwest.authorise.model.Userprofile;

public interface UserService 
{
	Userprofile addCustomer(Userprofile user);
	
	boolean validate(String userid,String password);


}
