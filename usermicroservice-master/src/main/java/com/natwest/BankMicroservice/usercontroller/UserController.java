package com.natwest.BankMicroservice.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.BankMicroservice.exceptions.UserAlreadyPresentException;
import com.natwest.BankMicroservice.exceptions.UserNotPresentException;

import com.natwest.BankMicroservice.user.Userprofile;
import com.natwest.BankMicroservice.userservice.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/api/user/registerUser")
	public ResponseEntity<?> addUser(@RequestBody Userprofile usernew) {
		try {
			Userprofile added=userservice.addUser(usernew);
			return new ResponseEntity<Userprofile>(added,HttpStatus.CREATED);
		} catch (UserAlreadyPresentException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		
	}
	
	@GetMapping("/api/user")
	public ResponseEntity<?> viewUsers() {
		List<Userprofile> users=userservice.viewUsers();
		return new ResponseEntity<List>(users,HttpStatus.OK);
		
	}
	
	@PutMapping("/api/user/updateUserDetails/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") String uId,@RequestBody Userprofile userupdated) {
		try {
			Userprofile updated=userservice.updateUser(userupdated,uId);
			return new ResponseEntity<Userprofile>(updated,HttpStatus.FOUND);
		} catch (UserNotPresentException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("api/user/view/{userId}")
	public ResponseEntity<?> viewbyId(@PathVariable("userId") String uId) {
		try {
			Userprofile view=userservice.viewbyId(uId);
			return new ResponseEntity<Userprofile>(view,HttpStatus.FOUND);
		} catch (UserNotPresentException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
}
