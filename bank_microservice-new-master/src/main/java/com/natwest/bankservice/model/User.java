package com.natwest.bankservice.model;

import java.util.List;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User 
{
	@Id
	String userid;
	
	int password;
	
	String firstName;
	String lastName;
	String mobile_number;
	
	List<Bank> banks_list;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public List<Bank> getBanks_list() {
		return banks_list;
	}

	public void setBanks_list(List<Bank> banks_list) {
		this.banks_list = banks_list;
	}

}
