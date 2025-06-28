package com.example.getfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.getfit.controller.User;
import com.example.getfit.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User save(User Userdetails) {
		return userRepository.save(Userdetails);
	}

	public List<User> listofAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public void DeleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public void DeleteAllUSer() {
		userRepository.deleteAll();
	}
}
