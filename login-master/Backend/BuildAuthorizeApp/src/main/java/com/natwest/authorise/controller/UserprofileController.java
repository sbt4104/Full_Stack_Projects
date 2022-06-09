package com.natwest.authorise.controller;

import java.sql.Date;
import java.util.HashMap;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.authorise.model.Userprofile;
import com.natwest.authorise.service.UserService;


import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin
public class UserprofileController 
{
	@Autowired
	UserService serv;
	
	@PostMapping("/natwest/addUser")
	public ResponseEntity<?> adduser(@RequestBody Userprofile user)
	{
		
		Userprofile obj=serv.addCustomer(user);
		return new ResponseEntity<Userprofile>(obj,HttpStatus.CREATED);
		
	}
	public String generateToken(Userprofile user)
	{
		
		long etime=1000000;
		
		return Jwts.builder().setSubject(user.getUserid())
							.setIssuedAt(new Date(System.currentTimeMillis()))
							.setExpiration(new Date(System.currentTimeMillis()+etime))
							.signWith(SignatureAlgorithm.HS256, "natwestkey")
							.compact();
							
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/natwest/login")
	
	public ResponseEntity<?> validateuser(@RequestBody Userprofile user)
	{
	boolean result= serv.validate(user.getUserid(), user.getPassword());
	
	if(result)
	{
		String tokresult=generateToken(user);
		
		
		HashMap map=new HashMap();
		map.put("Access Token",tokresult);
		return new ResponseEntity<HashMap>(map,HttpStatus.OK);
	}
	else
	{
		
		return new ResponseEntity<String>("User is not valid",HttpStatus.FORBIDDEN);
	}
	
	}
	


}
