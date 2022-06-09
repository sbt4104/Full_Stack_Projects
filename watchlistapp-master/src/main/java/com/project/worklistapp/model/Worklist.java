package com.project.worklistapp.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Worklist {

	@Id
	String id;
	
	String userid;
	
	List<String> stocklist;

	public Worklist()
	
	{
		
	}
	
	public Worklist(String id, String userid, List<String> stocklist) {
		this.id = id;
		this.userid = userid;
		this.stocklist = stocklist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<String> getStocklist() {
		return stocklist;
	}

	public void setStocklist(List<String> stocklist) {
		this.stocklist = stocklist;
	}
	
	
}
