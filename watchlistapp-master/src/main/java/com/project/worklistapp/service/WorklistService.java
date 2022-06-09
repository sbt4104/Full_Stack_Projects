package com.project.worklistapp.service;

import java.util.List;


import com.project.worklistapp.exception.UserNotFoundException;

public interface WorklistService {
	
	void addtoworklist(String userid, String stockname) ;
	List<String> getworklist(String userid) throws UserNotFoundException;
	List<String> deletestock(String userid, String stockname) throws UserNotFoundException;
	boolean deleteworklist(String userid) throws UserNotFoundException;
	

}
