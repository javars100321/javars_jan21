package com.bezkoder.spring.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fer")
public class FERController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/user/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		
		System.out.println("Login:");
		
		List<User> _user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		return new ResponseEntity<String>((_user!=null && !_user.isEmpty() ? "Login Successfull" : "Invalid User Login Faild"), HttpStatus.CREATED);
	}

}