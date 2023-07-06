package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping(value = "hello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Hello "+name;
	}
}
