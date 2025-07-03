package com.example.getfit.AdminService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.getfit.adminlogincontroller.Adminlogin;
import com.example.getfit.adminloginrepository.AdminRepository;
@Service
public class AdminService {
@Autowired
private AdminRepository adminRepository;

public Map<String, String> verifyAdmin(Adminlogin adminlogin) {
    Map<String, String> response = new HashMap<>();
    Adminlogin existingAdmin = adminRepository.findByName(adminlogin.getName());

    if (existingAdmin == null) {
        response.put("status", "error");
        response.put("message", "Invalid Admin username");
        return response;
    }

    if (!adminlogin.getPassword().equals(existingAdmin.getPassword())) {
        response.put("status", "error");
        response.put("message", "Invalid Password");
        return response;
    }

    response.put("status", "success");
    response.put("message", "Admin login successfully");
    return response;
}
}
