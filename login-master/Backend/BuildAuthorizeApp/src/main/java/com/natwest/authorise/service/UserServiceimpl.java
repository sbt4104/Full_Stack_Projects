package com.natwest.authorise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.authorise.model.Userprofile;
import com.natwest.authorise.repository.UserRepo;


@Service
public class UserServiceimpl implements UserService
{
	@Autowired
	UserRepo repo;


	@Override
	public Userprofile addCustomer(Userprofile user) 
	{
		 
		repo.save(user);
		return user;

	}

	@Override
	public boolean validate(String userid, String password) 
	{
		Userprofile obj= repo.findByUseridAndPassword(userid, password);
		// TODO Auto-generated method stub
		if(obj==null) 
		{
			return false;
		}
		else 
		{
			return true;
			
		}

	}

}
