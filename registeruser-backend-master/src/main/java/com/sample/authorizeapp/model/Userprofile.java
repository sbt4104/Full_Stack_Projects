package com.sample.authorizeapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Userprofile {

	@Id
	String useremail;
	int password;
	
	String fname, lname, mobile;
	
	
	
	
	public Userprofile()
	{
		
	}
	
	public Userprofile(String useremail, int password, String fname, String lname, String mobile
			) {
		this.useremail = useremail;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		
	}


	

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	
	
}
