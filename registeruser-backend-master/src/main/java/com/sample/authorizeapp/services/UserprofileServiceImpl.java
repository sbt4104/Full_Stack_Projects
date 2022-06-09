package com.sample.authorizeapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.authorizeapp.exception.UserAlreadyExistException;
import com.sample.authorizeapp.model.Userprofile;

import com.sample.authorizeapp.repository.UserprofileRepository;


@Service
public class UserprofileServiceImpl implements UserprofileService{

	
	@Autowired
	UserprofileRepository uprepo;
	

	
	@Override
	public Userprofile addUser(Userprofile user) throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		Optional<Userprofile> userById = uprepo.findById(user.getUseremail());
		if(userById.isPresent())
		{
			throw new UserAlreadyExistException("User Email already exists");
		}
		else {
//			Watchlist w = new Watchlist();
//			w.setUser(user);
//			wrepo.save(w);
//			user.setMywatchlist(w);
			return uprepo.save(user);
		}
		
	}

	

	@Override
	public List<Userprofile> getallusers() {
		// TODO Auto-generated method stub
		return uprepo.findAll();
	}
	

}
