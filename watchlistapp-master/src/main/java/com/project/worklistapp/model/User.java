package com.project.worklistapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Document
public class User {

	@Id
	String useremail;
	
	Worklist myworklist;
	
	

	public User()
	{
		
	}
	public User(String useremail, Worklist myworklist) {
		
		this.useremail = useremail;
		this.myworklist = myworklist;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Worklist getMyworklist() {
		return myworklist;
	}

	public void setMyworklist(Worklist myworklist) {
		this.myworklist = myworklist;
	}
	
	
}
