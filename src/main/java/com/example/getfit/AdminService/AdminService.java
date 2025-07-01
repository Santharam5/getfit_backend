package com.example.getfit.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.getfit.adminlogincontroller.Adminlogin;
import com.example.getfit.adminloginrepository.AdminRepository;
@Service
public class AdminService {
@Autowired
private AdminRepository adminRepository;
public String verifyAdmin(Adminlogin adminlogin) {
	Adminlogin existingAdmin=adminRepository.findByName(adminlogin.getName());
	if(existingAdmin==null) {
		return "Invalid Admin username";
	}
	if(!adminlogin.getPassword().equals(existingAdmin.getPassword())) {
		return "Invalid Password";
	}
	return "Admin login successfully";
}
}
