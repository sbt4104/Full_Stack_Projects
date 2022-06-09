package com.sample.authorizeapp.services;

import java.util.List;

import com.sample.authorizeapp.exception.UserAlreadyExistException;
import com.sample.authorizeapp.model.Userprofile;

public interface UserprofileService {

	Userprofile addUser(Userprofile user) throws UserAlreadyExistException ;
	
	List<Userprofile> getallusers();
}
