package com.example.getfit.userloginRestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getfit.userlogincontroller.Userlogin;
import com.example.getfit.userloginservices.Userloginservice;
@RestController
@RequestMapping("/api")
public class UserloginRestapi {
	@Autowired
private Userloginservice userloginservice;
	@PostMapping("/signup")
	public String signup(@RequestBody Userlogin userlogin) {
		return userloginservice.signup( userlogin);
		
	}
	
}
