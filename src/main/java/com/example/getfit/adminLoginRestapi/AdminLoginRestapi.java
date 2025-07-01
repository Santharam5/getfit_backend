package com.example.getfit.adminLoginRestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getfit.AdminService.AdminService;
import com.example.getfit.adminlogincontroller.Adminlogin;


@RestController
@RequestMapping("/api/admin")
public class AdminLoginRestapi {
@Autowired
private AdminService adminService;
@PostMapping("/login")
public String verifyAdmin(@RequestBody Adminlogin adminLogin) {
	return adminService.verifyAdmin(adminLogin);
}

}
