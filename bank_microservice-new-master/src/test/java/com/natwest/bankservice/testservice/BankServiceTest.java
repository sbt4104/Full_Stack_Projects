package com.natwest.bankservice.testservice;



import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations;

import com.natwest.bankservice.exceptions.BankDoesNotExistException;
import com.natwest.bankservice.exceptions.UserDoesNotExistException;
import com.natwest.bankservice.model.Bank;
import com.natwest.bankservice.model.User;
import com.natwest.bankservice.repository.BankRepo;
import com.natwest.bankservice.repository.UserRepo;
import com.natwest.bankservice.services.BankServiceImpl;

public class BankServiceTest 
{
	
	Bank bank;
	User user;

    @Mock
    BankRepo bank_repo;
    
    @Mock
    UserRepo user_repo;
    
    
    @InjectMocks
     BankServiceImpl bank_impl;
     List<Bank> bank_list = null;
     
    Optional<User> user_check;
    Optional<Bank> bank_check;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() throws Exception 
    {
    	
        MockitoAnnotations.initMocks(this);
        
        user =new User();
        user.setFirstName("DEEPAK");
        user.setLastName("MAHESHWARI");
        user.setUserid("deepak@gmail");
        
        bank=new Bank();
        
        bank.setAccount_number("123456");
        bank.setBank_name("DEEPAK HDFC");
        bank.setIfsc_code("HDFSC");
        bank.setAccount_type("PRIMARY");
        
        bank_list= user.getBanks_list();
        
        bank_list=new ArrayList<Bank>();
        bank_list.add(bank);
        user_check = Optional.of(user);
        bank_check=Optional.of(bank);
        
    }

    @Test
	public void adduser() throws Exception
	{
		Mockito.when(user_repo.save(user)).thenReturn(user);
		
		User bankresult=bank_impl.addUser(user);
		
		Assertions.assertEquals("deepak@gmail",bankresult.getUserid());
	}


	@Test
	public void addbank() throws Exception
	{	
		
	    when(user_repo.findById(user.getUserid())).thenReturn(user_check);
	 
		Mockito.when(bank_repo.save(bank)).thenReturn(bank);
		
		Bank bank_result=bank_impl.addBank(bank,user.getUserid());
		
		Assertions.assertEquals("DEEPAK HDFC",bank_result.getBank_name());
	}
	
	
	@Test
	public void testviewBanks() throws Exception
	{
		when(user_repo.findById(user.getUserid())).thenReturn(user_check);
		
		List<Bank> ls=user.getBanks_list();
		ls=new ArrayList<Bank>();
		ls.add(bank);
		user.setBanks_list(ls);

	   List<Bank> bank_result=bank_impl.viewBanks(user.getUserid());
		
	   Assertions.assertEquals(bank_result,user.getBanks_list());
		
	   
	}

	@Test
	public void testupdateBank() throws Exception
	{
		List<Bank> ls=user.getBanks_list();
		ls=new ArrayList<Bank>();
		ls.add(bank);
		user.setBanks_list(ls);
		
		Bank bank_new=new Bank();
		bank_new.setAccount_number(bank.getAccount_number());
		bank_new.setBank_name("NEW BANK");
		bank_new.setIfsc_code("NEW IFSC");
		when(user_repo.findById(user.getUserid())).thenReturn(user_check);
		when(bank_repo.findById(bank.getAccount_number())).thenReturn(bank_check);
		
		Bank bank_result=bank_impl.updateBank(bank_new, user.getUserid());
		 Assertions.assertEquals(bank_result.getBank_name(),"NEW BANK");
		
	}
	

    @Test
    public void deletebankSuccess() throws BankDoesNotExistException, UserDoesNotExistException 
    {
		when(user_repo.findById(user.getUserid())).thenReturn(user_check);
		List<Bank> ls=user.getBanks_list();
		ls=new ArrayList<Bank>();
		ls.add(bank);
		user.setBanks_list(ls);
     
        boolean flag = bank_impl.deleteBank(user.getUserid(), bank.getAccount_number());
        Assertions.assertEquals(true, flag);
    }


	@Test
	public void testmakePrimary() throws Exception
	{
		Bank bank_new=new Bank();
		bank_new.setAccount_number("56789");
		bank_new.setBank_name("NEW BANK");
		bank_new.setIfsc_code("NEW IFSC");
		bank_new.setAccount_type("SECONDARY");
		bank.setAccount_type("SECONDARY");
		
		List<Bank> ls=user.getBanks_list();
		ls=new ArrayList<Bank>();
		ls.add(bank);
		ls.add(bank_new);
		user.setBanks_list(ls);
	
		when(user_repo.findById(user.getUserid())).thenReturn(user_check);
		when(bank_repo.findById(bank_new.getAccount_number())).thenReturn(bank_check);

        boolean flag = bank_impl.makeprimary(user.getUserid(), bank_new.getAccount_number());
        Assertions.assertEquals(true, flag);
	}
	


    
	

}
