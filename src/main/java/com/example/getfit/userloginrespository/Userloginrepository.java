package com.example.getfit.userloginrespository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.getfit.userlogincontroller.Userlogin;

public interface Userloginrepository extends JpaRepository<Userlogin,Integer> {
	Userlogin  findByName(String name);
}
