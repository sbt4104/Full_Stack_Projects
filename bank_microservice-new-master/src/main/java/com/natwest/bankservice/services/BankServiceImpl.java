package com.natwest.bankservice.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.bankservice.exceptions.BankAlreadyExistException;
import com.natwest.bankservice.exceptions.BankDoesNotExistException;
import com.natwest.bankservice.exceptions.UserAlreadyExistException;
import com.natwest.bankservice.exceptions.UserDoesNotExistException;
import com.natwest.bankservice.model.Bank;
import com.natwest.bankservice.model.User;
import com.natwest.bankservice.repository.BankRepo;
import com.natwest.bankservice.repository.UserRepo;


@Service
public class BankServiceImpl implements BankService 
{
	//to interact with bank db
	@Autowired
	BankRepo bank_repo;

	//to interact with user db
	@Autowired
	UserRepo user_repo;

	@Override
	public User addUser(User user_obj) throws UserAlreadyExistException
	{
		//check for existence
		Optional<User> user_check=user_repo.findById(user_obj.getUserid());
		
		//if present
		if(user_check.isPresent()) 
		{
			throw new UserAlreadyExistException("User Already Exists");
		}
		//save into the database
		else 
		{
			user_repo.save(user_obj);
			return user_obj;
		}
		
	}
	
	

	@Override
	public Bank addBank(Bank bank_obj, String user_id) throws BankAlreadyExistException, UserDoesNotExistException 
	{
		//first check whether the user exist or not
		Optional<User> user_check=user_repo.findById(user_id);
		
		//if user exist then we can go for adding bank
		if(user_check.isPresent()) 
		{
			//check if this account is already exists
			Optional<Bank> bank_check=bank_repo.findById(bank_obj.getAccount_number());
			
			if(bank_check.isPresent()) 
			{
				throw new BankAlreadyExistException("Bank already exists with this account number");
			}
			else 
			{
				User user_obj=user_check.get();
				//if it's his first time it will be treated as primary bank
				List<Bank> bank_ls=user_obj.getBanks_list();
				if(bank_ls==null || bank_ls.size()==0) 
				{
					bank_ls= new ArrayList<Bank>();
					bank_obj.setAccount_open(LocalDate.now());
					bank_obj.setAccount_type("PRIMARY");
					bank_ls.add(bank_obj);
					user_obj.setBanks_list(bank_ls);
					
				}
				//otherwise it will be treated as secondary bank
				else 
				{	
					bank_obj.setAccount_open(LocalDate.now());
					bank_obj.setAccount_type("SECONDARY");
					bank_ls.add(bank_obj);
					user_obj.setBanks_list(bank_ls);
				}
				
				bank_repo.save(bank_obj);
				user_repo.save(user_obj);
				return bank_obj;
				
			}
			
		}
		else 
		{
			throw new UserDoesNotExistException ("User does not exist first make sure you are registered");
		}
	
	}

	@Override
	public List<Bank> viewBanks(String userid) throws BankDoesNotExistException, UserDoesNotExistException 
	{
		
		Optional<User> user_check=user_repo.findById(userid);
		
		//if user does exist then we can check
		if(user_check.isPresent()) 
		{
			User user_obj=user_check.get();
			if(user_obj.getBanks_list()==null || user_obj.getBanks_list().size()==0) 
			{
				throw new BankDoesNotExistException("Bank Does not exists ,please add your bank");
				
			}
			else 
			{
				List<Bank> bank_list=user_obj.getBanks_list();
				return bank_list;
			}
		}
		else 
		{
			throw new UserDoesNotExistException ("User does not exist first make sure you are registered");
		}
		
	}

	@Override
	public Bank updateBank(Bank bank_obj, String user_id) throws BankDoesNotExistException ,UserDoesNotExistException
	{
		
		Optional<User> user_check=user_repo.findById(user_id);
		//if user is present then we can look for the bank
		if(user_check.isPresent()) 
		{
			Optional<Bank> bank_check=bank_repo.findById(bank_obj.getAccount_number()); 
			if(bank_check.isPresent()) 
			{
				Bank new_obj=new Bank();
				
				User user_obj=user_check.get();
				Bank prev_obj=bank_check.get();
				if(user_obj.getBanks_list().size()==1)
				{
					new_obj.setAccount_type("PRIMARY");
					new_obj.setAccount_number(bank_obj.getAccount_number());
					new_obj.setBank_name(bank_obj.getBank_name());
					new_obj.setIfsc_code(bank_obj.getIfsc_code());
					new_obj.setAccount_open(prev_obj.getAccount_open());
					user_obj.getBanks_list().add(new_obj);
					user_obj.getBanks_list().remove(0);
					
				}
				else 
				{
					
					if(user_obj.getBanks_list().size()>1)
					{
						new_obj.setAccount_number(bank_obj.getAccount_number());
						new_obj.setBank_name(bank_obj.getBank_name());
						new_obj.setIfsc_code(bank_obj.getIfsc_code());
						new_obj.setAccount_open(prev_obj.getAccount_open());
						new_obj.setAccount_type(prev_obj.getAccount_type());
					
						int idx=0,i=0;
						for(Bank x: user_obj.getBanks_list()) 
						{
							if(x.getAccount_number().equals(bank_obj.getAccount_number())) 
							{
								idx=i;
								break;
							}
							i++;
						}
						user_obj.getBanks_list().remove(idx);
						user_obj.getBanks_list().add(idx,new_obj);
					}
					
				}
				
				bank_repo.deleteById(bank_obj.getAccount_number());
				bank_repo.save(new_obj);
				user_repo.save(user_obj);
				return new_obj;
				
			}
			else 
			{
				throw new BankDoesNotExistException("Bank Does not exists with this account number");
			}
		}
		else 
		{
			throw new UserDoesNotExistException ("User does not exist first make sure you are registered");
		}
		
		
	}

	@Override
	public boolean deleteBank(String userid,String account_number) throws BankDoesNotExistException ,UserDoesNotExistException
	{

		Optional<User> user_check=user_repo.findById(userid);
		//if user is present then we can look for the bank
		
		
		if(user_check.isPresent()) 
		{
			//look for the particular bank;
			User user_obj=user_check.get();
			List<Bank> bank_ls=user_obj.getBanks_list();
			
			if(bank_ls==null||bank_ls.size()==0) 
			{
				throw new  BankDoesNotExistException("Bank account does not exists");
			}
			
			int f=0;
			int idx=0,i=0;
			for(Bank x:bank_ls) 
			{
				if(x.getAccount_number().equals(account_number)) 
				{
					f=1;
					idx=i;
					break;
				}
				i++;
			}
			
			if(bank_ls.get(idx).getAccount_type().equals("PRIMARY")&&bank_ls.size()>1) 
			{
				throw new  BankDoesNotExistException("You can not delete primary account while having secondary accounts");
				
			}
			if(f==0) 
			{
				
				throw new  BankDoesNotExistException("Enter the valid account number or it may be already got deleted");
				
			}
			else
			{
				bank_repo.deleteById(account_number);
				user_obj.getBanks_list().remove(idx);
				user_repo.save(user_obj);
				return true;
						
			}
			
			
		}
		else 
		{
			throw new UserDoesNotExistException("User does not exist first make sure you are registered");
		}
		
	}



	@Override
	public boolean deleteallbank(String userid) throws UserDoesNotExistException , BankDoesNotExistException
	{
		Optional<User> user_check=user_repo.findById(userid);
		
		if(user_check.isPresent()) 
		{
			User user_obj=user_check.get();
			
			if(user_obj.getBanks_list()==null || user_obj.getBanks_list().size()==0) 
			{
			 throw new  BankDoesNotExistException("You need to have banks to get deleted");
				
			}
			else 
			{
				user_obj.setBanks_list(null);
				bank_repo.deleteAll();
				user_repo.save(user_obj);
				return true;
			}
		}
		else 
		{
			throw new UserDoesNotExistException("User does not exist first make sure you are registered");
		}
		
		
	}
	
	public boolean deleteuser(String userid) throws UserDoesNotExistException
	{
		Optional<User> user_check=user_repo.findById(userid);
		
		if(user_check.isPresent()) 
		{
			User user_obj =user_check.get();
			
			List<Bank> ls=user_obj.getBanks_list();
			if(ls==null || ls.size()==0) 
			{
				user_repo.deleteById(userid);
				return true;
			}
			else 
			{
				for(Bank x:ls) 
				{
					bank_repo.deleteById(x.getAccount_number());
				}
				user_repo.deleteById(userid);
				return true;
			}
	
		}
		else 
		{
			throw new UserDoesNotExistException("User does not exist");
		}
		
	}



	@Override
	public boolean makeprimary(String userid, String account_number) throws BankDoesNotExistException, UserDoesNotExistException 
	{
		Optional<User> user_check=user_repo.findById(userid);
		
		if(user_check.isPresent()) 
		{
			User user_obj=user_check.get();
			
			Optional<Bank> bank_check=bank_repo.findById(account_number);
			
			if(bank_check.isPresent()) 
			{
				
				Bank b_o=bank_check.get();
				
				if(b_o.getAccount_type().equals("PRIMARY")) 
				{
					 throw new  BankDoesNotExistException("It is already a primary");
				}
				else 
				{
					List<Bank> bank_ls=user_obj.getBanks_list();
					
					for(Bank x:bank_ls) 
					{
						if(x.getAccount_number().equals(account_number))
						{
							x.setAccount_type("PRIMARY");
						}
						else 
						{
							x.setAccount_type("SECONDARY");
						}
					}
					
					user_repo.save(user_obj);
					bank_repo.deleteAll();
					
					for(Bank x:bank_ls) 
					{
						bank_repo.save(x);
					}	
					
					
					return true;
				}	
			}
			else 
			{
				 throw new  BankDoesNotExistException("Bank does not exist");
			}
		}
		else 
		{
			throw new UserDoesNotExistException("User does not exist first make sure you are registered");
		}
		
		
		
	}

	


	
}
