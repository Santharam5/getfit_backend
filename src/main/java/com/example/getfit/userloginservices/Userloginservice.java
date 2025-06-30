package com.example.getfit.userloginservices;

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
public String login( Userlogin userlogin) {
	Userlogin existingUser = userloginrepository.findByName(userlogin.getName());

    if (existingUser == null) {
        return "Invalid username!";
    }

    if (!userlogin.getPassword().equals(existingUser.getPassword())) {
        return "Invalid password!";
    }

    return "Login successful!";
}
}
