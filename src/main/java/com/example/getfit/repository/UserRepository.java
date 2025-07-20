package com.example.getfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.getfit.controller.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
