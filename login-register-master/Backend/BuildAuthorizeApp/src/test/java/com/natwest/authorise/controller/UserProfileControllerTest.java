package com.natwest.authorise.controller;



import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.authorise.Exceptions.UserAlreadyExists;
import com.natwest.authorise.model.Userprofile;
import com.natwest.authorise.service.UserService;

@SpringBootTest
public class UserProfileControllerTest {

	MockMvc mockmvcobj;
	
	@MockBean
	UserService userService;
	
	@InjectMocks
	UserprofileController userprofileController;
	
	Userprofile userprofile;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		mockmvcobj=MockMvcBuilders.standaloneSetup(userprofileController).build();
		
		userprofile = new Userprofile();
		userprofile.setFn("ayush");
		userprofile.setLn("yadav");
		userprofile.setPassword("1234");
		userprofile.setUserid("ayushy8@gmail.com");
		userprofile.setPhone("9810202944");
	}
	
	public String convertObjtoString(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
		String result=objmap.writeValueAsString(obj);
			return result;
	}
	
	
	@Test
	public void AddUserAndReturnSuccess() throws Exception
	{
		Mockito.when(userService.addCustomer(userprofile)).thenReturn(userprofile);
		
		mockmvcobj.perform(MockMvcRequestBuilders.post("/natwest/addUser").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(userprofile))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void ValidateUserAndReturnOK() throws Exception{
		Mockito.when(userService.validate(userprofile.getUserid(), userprofile.getPassword())).thenReturn(true);
		
		mockmvcobj.perform(MockMvcRequestBuilders.post("/natwest/login").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(userprofile))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void addUserFailure() throws Exception {

		Mockito.when(userService.addCustomer(any())).thenThrow(UserAlreadyExists.class);
		
		mockmvcobj.perform(MockMvcRequestBuilders.post("/natwest/addUser").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(userprofile)))
				.andExpect(MockMvcResultMatchers.status().isConflict());

	}


}
