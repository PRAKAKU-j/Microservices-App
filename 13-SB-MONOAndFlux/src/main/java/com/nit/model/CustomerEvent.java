package com.nit.model;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerEvent {

	private String name;
	private Date date;
	
	public CustomerEvent(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	
	
	
}
