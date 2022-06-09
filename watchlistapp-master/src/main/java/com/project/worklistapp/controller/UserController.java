package com.project.worklistapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.worklistapp.exception.UserNotFoundException;
import com.project.worklistapp.model.Worklist;
import com.project.worklistapp.service.WorklistService;

@RestController
@CrossOrigin
@RequestMapping("/api/stockapp/worklist/{userid}")
public class UserController {

	@Autowired
	WorklistService wservice;
	
	
	@PostMapping("/addstock")
	public ResponseEntity<?> addstock(@PathVariable("userid") String userid, @RequestBody String stockname)
	{
		
		wservice.addtoworklist(userid, stockname);
		
		return new ResponseEntity<String>(stockname,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletestock")
	public ResponseEntity<?> deletestock(@PathVariable("userid") String userid, @RequestBody String stockname)
	{
		List<String> sresult;
		try {
			sresult = wservice.deletestock(userid, stockname);
			return new ResponseEntity<List>(sresult,HttpStatus.CREATED);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		
		
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteworklist(@PathVariable("userid") String userid)
	{
		try {
			wservice.deleteworklist(userid);
			return new ResponseEntity<String>("Deleted Worklist for User",HttpStatus.CREATED);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> viewstocklist(@PathVariable("userid") String userid)
	{
		 List<String> stocks;
		try {
			stocks = wservice.getworklist(userid);
			return new ResponseEntity<List>(stocks,HttpStatus.OK);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		 
	}
	
	

}
