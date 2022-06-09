package com.natwest.BankMicroservice.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userprofile")
public class Userprofile{
	@Id
	String userid;
		
	Integer password;
	String fn;
	String ln;
	String phone;
		
		
		
		public Userprofile(){
			
		}



		public Userprofile(String userid, Integer password, String fn ,String ln, String phone) {
			
			this.userid = userid;
			this.password = password;
			this.fn = fn;
			this.ln = ln;
			this.phone = phone;
			
		}


		public String getUserId() {
			return userid;
		}
		public void setUserId(String userid) {
			this.userid = userid;
		}
		public Integer getPassword() {
			return password;
		}
		public void setPassword(Integer password) {
			this.password = password;
		}
		public String getFirstName() {
			return fn;
		}
		public void setFirstName(String fn) {
			this.fn = fn;
		}
		public String getLastName() {
			return ln;
		}
		public void setLastName(String ln) {
			this.ln = ln;
		}
		public String getMobileNumber() {
			return phone;
		}
		public void setMobileNumber(String phone) {
			this.phone = phone;
		}
			}



