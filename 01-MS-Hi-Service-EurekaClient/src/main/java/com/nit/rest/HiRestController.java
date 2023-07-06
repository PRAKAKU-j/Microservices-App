package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.client.HelloClient;

@RestController
public class HiRestController {
	
	@Autowired
	private HelloClient helloClient;

	@GetMapping(value = {"/hi/{name}"})
	public String sayHi(@PathVariable("name") String name) {
	
		String invokeHelloService = helloClient.invokeHelloService(name);
		
		return "Hi "+invokeHelloService;
	}
}
