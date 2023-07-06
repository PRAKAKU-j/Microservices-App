package com.nit.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printDate {

	@GetMapping("date ")
		public String printDate() {
			return "Today is ::"+new Date();
		}
	
}
