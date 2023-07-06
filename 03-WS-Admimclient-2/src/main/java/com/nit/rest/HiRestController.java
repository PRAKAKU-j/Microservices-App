package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRestController {

	@GetMapping("/hi")
	public String HiMsg() {
		return "Hi,Radhay Radhay";
	}
}
