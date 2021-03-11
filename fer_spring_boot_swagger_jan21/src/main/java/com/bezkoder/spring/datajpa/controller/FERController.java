package com.bezkoder.spring.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Expense;
import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.ExpenseRepository;
import com.bezkoder.spring.datajpa.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class FERController {

	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	UserRepository userRepository;

	@DeleteMapping("/expense/{expenseId}")
	public ResponseEntity<HttpStatus> deleteExpense(@PathVariable("expenseId") int expenseId) {

		try {
			expenseRepository.deleteById(expenseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/editexpense/{expenseId}")
	public ResponseEntity<Expense> editExpense(@PathVariable int expenseId, @RequestBody Expense expense) {

		try {

			Expense _expense = expenseRepository.save(expense);

			return new ResponseEntity<>(_expense, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateUser/{userid}")
	public ResponseEntity<User> updateUser(@PathVariable("userid") int id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userRepository.save((new User(user.getFirstname(), user.getMiddlename(), user.getLastname(),
					user.getEmail(), user.getUsername(), user.getPassword(), user.getMobile())));

			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/resetPassword/{userId}")
	public ResponseEntity<String> resetPassword(@PathVariable("userId") int id, @RequestParam String currentpassword,
			@RequestParam String newpassword) {

		User _user = getUserById(id).getBody();

		if ("currentPassword" != null) {
			_user.setPassword(newpassword);
			return new ResponseEntity<>((_user.getPassword() == newpassword ? "changed resetpassword" : "Invalid User"),
					HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

}
