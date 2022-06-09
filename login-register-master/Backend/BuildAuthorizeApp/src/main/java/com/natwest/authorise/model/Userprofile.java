package com.natwest.authorise.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userprofile 
{
	@Id
	String userid;
	String   password;
	String fn,ln,phone;

	public Userprofile() {}
	
	public Userprofile(String userid, String password, String fn, String ln, String phone) {
		this.userid = userid;
		this.password = password;
		this.fn = fn;
		this.ln = ln;
		this.phone = phone;
	}
	
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
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	

}
