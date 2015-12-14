package com.imhere.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imhere.model.User;

@RestController
public class LoginController {
	
	@RequestMapping(value = "/login/{timestamp}/", method = RequestMethod.POST)
	public void login(@PathVariable String timestamp, User user) {

		
	}
}