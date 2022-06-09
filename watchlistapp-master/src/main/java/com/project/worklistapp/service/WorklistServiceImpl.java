package com.project.worklistapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.worklistapp.exception.UserAlreadyExistException;
import com.project.worklistapp.exception.UserNotFoundException;
import com.project.worklistapp.model.User;
import com.project.worklistapp.model.Worklist;
import com.project.worklistapp.repository.UserRepository;
import com.project.worklistapp.repository.WorklistRepository;

@Service
public class WorklistServiceImpl implements WorklistService{

	@Autowired
	WorklistRepository wrepo;
	
	@Autowired
	UserRepository urepo;
	
	@Override
	public void addtoworklist(String userid, String stockname) {
		// TODO Auto-generated method stub
		int i = stockname.indexOf(':');
		int j = stockname.indexOf('}');
		String tempi = stockname.substring(i+2,j-1);
		tempi = tempi.trim();
		System.out.println("Processing string "+tempi);
		Optional<User> useropt=urepo.findById(userid);
		
		List<String> temp ;
		if(useropt.isPresent())
		{
		    	
		    	User u = useropt.get();
		    	System.out.println(u.getUseremail());
		    	if(u.getMyworklist()==null)
		    	{
		    		temp =  new ArrayList<String>();
		    		temp.add(tempi);
		    		Worklist w = new Worklist();
		    		w.setUserid(userid);
		    		w.setStocklist(temp);
		    		wrepo.save(w);
		    		u.setMyworklist(w);
		    		urepo.save(u);
		    	
		    	}
		    	else
		    	{
		    		Worklist w  = u.getMyworklist();
		    		temp = w.getStocklist();
		    		Set<String> hset = new HashSet<String>();
		    		for(String x: temp)
		    			hset.add(x);
		    		
		    		hset.add(tempi);
		    		List<String> temp2 =  new ArrayList<String>();
		    		
		    		for(String y: hset)
		    			temp2.add(y);
		    		w.setStocklist(temp2);
		    		wrepo.save(w);
		    		u.setMyworklist(w);
		    		urepo.save(u);
		    		
		    	}
		    	
		}
			
		else
		{
			User userobj = new User();
			userobj.setUseremail(userid);
			temp =  new ArrayList<String>();
    		temp.add(tempi);
    		Worklist w = new Worklist();
    		w.setUserid(userid);
    		w.setStocklist(temp);
    		wrepo.save(w);
    		userobj.setMyworklist(w);
    		urepo.save(userobj);
			
			
		}
		
	}

	@Override
	public List<String> getworklist(String userid) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<User> useropt=urepo.findById(userid);
		List<String> result;
		
		if(useropt.isPresent())
		{
			User u = useropt.get();
			result = u.getMyworklist().getStocklist();
//			for(var e: result)
//			{
//				System.out.println(e);
//			}
			return result;
		}
		else
			throw new UserNotFoundException("Useremail doesnot exist");
		
	}

	@Override
	public List<String> deletestock(String userid, String stockname) throws UserNotFoundException{
		// TODO Auto-generated method stub
		System.out.println("String to delete "+stockname);
		int p = stockname.indexOf(':');
		
		String tempi = stockname.substring(p+1,stockname.length()-1);
		tempi = tempi.trim();
		
		System.out.println("Processing string "+tempi);
		Optional<User> useropt=urepo.findById(userid);
		List<String> result;
		int pos = -1;
		if(useropt.isPresent())
		{
			User u = useropt.get();
			System.out.println("User is "+ u.getUseremail());
			Worklist w = u.getMyworklist();
			result = w.getStocklist();
			
			System.out.println(tempi);
			tempi = tempi.replace("\"","");
			for(String e : result)
			{
				System.out.println(e);
				if(e.equalsIgnoreCase(tempi))
				{
					pos = result.indexOf(e);
					System.out.println(pos);
					break;
				}
			}
			if(pos!=-1)
			{
				
				result.remove(pos);
				System.out.println(result);
	    		w.setStocklist(result);
	    		wrepo.save(w);
	    		u.setMyworklist(w);
	    		urepo.save(u);
				return result;
			}
			else
				return result;
		}
		else
			throw new UserNotFoundException("Useremail doesnot exist");
	}

	@Override
	public boolean deleteworklist(String userid) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> useropt=urepo.findById(userid);
		List<String> result;
		
		if(useropt.isPresent())
		{
			User u = useropt.get();
			Worklist w = u.getMyworklist();
			result = w.getStocklist();
			result = new ArrayList<String>();
    		w.setStocklist(result);
    		wrepo.save(w);
    		u.setMyworklist(w);
    		urepo.save(u);
			return true;
		}
		else
			throw new UserNotFoundException("Useremail doesnot exist");
	}

}
