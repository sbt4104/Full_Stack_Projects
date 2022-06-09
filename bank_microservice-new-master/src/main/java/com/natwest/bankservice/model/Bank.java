package com.natwest.bankservice.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Bank 
{
	//primary key
	@Id
	String account_number;
	String bank_name;
	String ifsc_code;
	String account_type;


	LocalDate account_open;
	
	public Bank()
	{
		
	}
	
	//getters and setters
	

	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_open(LocalDate account_open) {
		this.account_open = account_open;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public String getBank_name() {
		return bank_name;
	}


	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}


	public String getIfsc_code() {
		return ifsc_code;
	}


	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}


	public String getAccount_type() {
		return account_type;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}


	public LocalDate getAccount_open() {
		return account_open;
	}

	@Override
	public String toString() {
		return "Bank [account_number=" + account_number + ", bank_name=" + bank_name + ", ifsc_code=" + ifsc_code
				+ ", account_type=" + account_type + ", account_open=" + account_open + "]";
	}

	
	

	
}
