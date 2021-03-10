package com.bezkoder.spring.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.ExpenseRepository;
import com.bezkoder.spring.datajpa.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class FERGetUserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ExpenseRepository expenseRepository;

	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		Optional<User> _user = userRepository.findById(id);

		if (_user.isPresent()) {
			return new ResponseEntity<>(_user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
