package com.example.getfit.userloginservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.getfit.userlogincontroller.Userlogin;
import com.example.getfit.userloginrespository.Userloginrepository;
@Service
public class Userloginservice {
@Autowired
private Userloginrepository userloginrepository;

public String signup(Userlogin userlogin) {
	if(userloginrepository.findByName(userlogin.getName())!=null)
	{
		return "User is already exist";
	}
		
		userloginrepository.save(userlogin);
		return "Signup successfully";
	
}
public Map<String, String> login(Userlogin userlogin) {
    Map<String, String> response = new HashMap<>();
    Userlogin existingUser = userloginrepository.findByName(userlogin.getName());

    if (existingUser == null) {
        response.put("status", "error");
        response.put("message", "Invalid username!");
        return response;
    }

    if (!userlogin.getPassword().equals(existingUser.getPassword())) {
        response.put("status", "error");
        response.put("message", "Invalid password!");
        return response;
    }

    response.put("status", "success");
    response.put("message", "Login successful!");
    return response;
}}
