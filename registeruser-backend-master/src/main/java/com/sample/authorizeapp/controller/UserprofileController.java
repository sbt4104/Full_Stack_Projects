package com.sample.authorizeapp.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.authorizeapp.exception.UserAlreadyExistException;
import com.sample.authorizeapp.model.Userprofile;
import com.sample.authorizeapp.services.UserprofileService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class UserprofileController {
	
	@Autowired
	UserprofileService upservice;
	
	@PostMapping("/register")
	public ResponseEntity<?> adduser(@RequestBody Userprofile user)
	{
		
		Userprofile userprofileresult=null;
		try {
			userprofileresult = upservice.addUser(user);
			return new ResponseEntity<Userprofile>(userprofileresult,HttpStatus.CREATED);
		} catch (UserAlreadyExistException e) {
			// TODO Auto-generated catch block
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<?> getusers()
	{
		return new ResponseEntity(upservice.getallusers(),HttpStatus.OK);
	}
}
