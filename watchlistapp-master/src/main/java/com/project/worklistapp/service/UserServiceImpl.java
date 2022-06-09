package com.project.worklistapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.worklistapp.exception.UserAlreadyExistException;
import com.project.worklistapp.model.User;
import com.project.worklistapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository urepo;
	
	@Override
	public User adduser(String useremail) throws UserAlreadyExistException{
		// TODO Auto-generated method stub
		
		Optional<User> useropt=urepo.findById(useremail);
		
		if(useropt.isPresent())
		{
		    	
		    	throw new UserAlreadyExistException("Useremail already exists");
		    	
		}
			
		else
		{
			User userobj = new User();
			userobj.setUseremail(useremail);
			
			urepo.save(userobj);
			return userobj;
		}

	}

	@Override
	public boolean deleteuser(String useremail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User finduser(String useremail) {
		// TODO Auto-generated method stub
		return null;
	}

}
