package com.example.getfit.adminloginrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.getfit.adminlogincontroller.Adminlogin;

public interface AdminRepository extends JpaRepository<Adminlogin, Integer>{
Adminlogin findByName(String name);
}
