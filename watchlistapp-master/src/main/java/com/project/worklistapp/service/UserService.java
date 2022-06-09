package com.project.worklistapp.service;

import com.project.worklistapp.exception.UserAlreadyExistException;
import com.project.worklistapp.exception.UserNotFoundException;
import com.project.worklistapp.model.User;

public interface UserService {

	User adduser(String useremail) throws UserAlreadyExistException;
	boolean deleteuser(String useremail) throws UserNotFoundException;
	User finduser(String useremail) throws UserNotFoundException;
	
}
