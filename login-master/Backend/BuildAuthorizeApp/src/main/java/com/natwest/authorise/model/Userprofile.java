package com.natwest.authorise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userprofile 
{
	@Id
	String userid;
	String   password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userprofile() {}
	
	public Userprofile(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	

}
