package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces="text/plain")
     public String adminReuest(){
		return "hello admin";
	}
}
