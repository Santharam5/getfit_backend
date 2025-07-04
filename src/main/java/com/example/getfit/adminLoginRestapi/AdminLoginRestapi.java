package com.example.getfit.adminLoginRestapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getfit.AdminService.AdminService;
import com.example.getfit.adminlogincontroller.Adminlogin;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com"})

public class AdminLoginRestapi {
@Autowired
private AdminService adminService;
@PostMapping("/adminlogin")
public Map<String, String> adminLogin(@RequestBody Adminlogin adminlogin) {
    return adminService.verifyAdmin(adminlogin);
}
}
