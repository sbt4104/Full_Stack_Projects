package com.natwest.authorise.service;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.natwest.authorise.Exceptions.UserAlreadyExists;
import com.natwest.authorise.model.Userprofile;
import com.natwest.authorise.repository.UserRepo;

public class UserProfileServiceTests {
	@Mock
	UserRepo userRepo;
	
	@InjectMocks
	UserServiceimpl userServiceimpl;
	
	Userprofile userprofile;
	
	@BeforeEach
	public void intialize()
	{
		MockitoAnnotations.initMocks(this);
		
		userprofile = new Userprofile();
		userprofile.setFn("ayush");
		userprofile.setLn("yadav");
		userprofile.setPassword("1234");
		userprofile.setUserid("ayushy8@gmail.com");
		userprofile.setPhone("9810202944");
		
	}
	

	@Test
	public void WhenAddUserReturnUser() throws Exception
	{
		Mockito.when(userRepo.save(userprofile)).thenReturn(userprofile);
		
		Userprofile res=userServiceimpl.addCustomer(userprofile);
		
		Assertions.assertEquals("ayushy8@gmail.com",res.getUserid());
	}
	
	
	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void AddUserFailure() throws UserAlreadyExists
//	{
//	Mockito.when(userRepo.getById(any())).thenThrow(UserAlreadyExists.class);
//	
//	Assertions.assertThrows(UserAlreadyExists.class, ()->userServiceimpl.addCustomer(userprofile));
//	
//		
//		Mockito.verify(userRepo, times(1)).getById(any());
//		Mockito.verify(userRepo, times(0)).save(any());
//
//	}

}
