package com.natwest.bankservice.testcontroller;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.MockMvcBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.bankservice.controller.BankController;
import com.natwest.bankservice.model.Bank;
import com.natwest.bankservice.model.User;
import com.natwest.bankservice.services.BankService;


import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;




@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest 
{
	MockMvc mockmvcobj;
	
	@MockBean
	BankService bank_Service;
	
	@MockBean
	Bank bank;
	
	@MockBean
	User user;
	
	
	@InjectMocks
	BankController bank_controller;
	
	
	List<Bank> bank_list;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		mockmvcobj=MockMvcBuilders.standaloneSetup(bank_controller).build();
		
		

		user=new User();
		user.setUserid("deepak");
		user.setFirstName("DEEPAK");
		user.setLastName("Maheshwari");
		user.setMobile_number("9837052398");
		user.setPassword(1234);
		
		
		bank = new Bank();
		bank.setAccount_number("1234");
		bank.setBank_name("STANDARD CHARTERED BANK");
		bank.setIfsc_code("STD123");
		
		bank_list=new ArrayList<Bank>();
		bank_list.add(bank);
		
		user.setBanks_list(bank_list);
		
		
	}
	
	public String convertObjtoString(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
		String result=objmap.writeValueAsString(obj);
			return result;
	}
	
	
	
	@Test
	public void testAddbank() throws Exception
	{
		Mockito.when(bank_Service.addBank(bank, user.getUserid())).thenReturn(bank);
		mockmvcobj.perform(MockMvcRequestBuilders.post("/api/bank/addbank/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	
	@Test
	public void testviewBanks() throws Exception
	{
		Mockito.when(bank_Service.viewBanks(user.getUserid())).thenReturn(bank_list);
		mockmvcobj.perform(MockMvcRequestBuilders.get("/api/bank/viewbanks/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void testupdateBank() throws Exception
	{
		Bank bank_new=new Bank();
		bank_new.setAccount_number(bank.getAccount_number());
		bank_new.setBank_name("NEW BANK");
		bank_new.setIfsc_code("NEW IFSC");
		Mockito.when(bank_Service.updateBank(bank_new, user.getUserid())).thenReturn(bank);
		mockmvcobj.perform(MockMvcRequestBuilders.put("/api/bank/updatebank/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
		
	}
	
	@Test
	public void testdeleteBank() throws Exception
	{
		Mockito.when(bank_Service.deleteBank(user.getUserid(), bank.getAccount_number())).thenReturn(true);
		mockmvcobj.perform(MockMvcRequestBuilders.delete("/api/bank/deletebank/"+bank.getAccount_number()+"/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void testdeleteALLBank() throws Exception
	{
		Mockito.when(bank_Service.deleteallbank(user.getUserid())).thenReturn(true);
		mockmvcobj.perform(MockMvcRequestBuilders.delete("/api/bank/deleteAllbanks/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void testmakePrimary() throws Exception
	{
		Mockito.when(bank_Service.makeprimary(user.getUserid(), bank.getAccount_number())).thenReturn(true);
		mockmvcobj.perform(MockMvcRequestBuilders.put("/api/bank/makeprimary/"+bank.getAccount_number()+"/"+user.getUserid()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(bank))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	
	
}









