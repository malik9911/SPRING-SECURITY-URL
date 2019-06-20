package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces="test/plain")
	public String  hello(){
		
		
		System.out.println("in hello spring ");
		return "hello";
	}
	
	
}
