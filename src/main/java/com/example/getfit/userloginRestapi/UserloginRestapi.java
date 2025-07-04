package com.example.getfit.userloginRestapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getfit.userlogincontroller.Userlogin;
import com.example.getfit.userloginservices.Userloginservice;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com","https://get-4hrrx71dq-santharam-bs-projects.vercel.app"})
public class UserloginRestapi {
	@Autowired
private Userloginservice userloginservice;
	@PostMapping("/signup")
	public String signup(@RequestBody Userlogin userlogin) {
		return userloginservice.signup( userlogin);
		
	}
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Userlogin userlogin) {
	    Map<String, String> response = userloginservice.login(userlogin);
	    return response;
	}

	
}
