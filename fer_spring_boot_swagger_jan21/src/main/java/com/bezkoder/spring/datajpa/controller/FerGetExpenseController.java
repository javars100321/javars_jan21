package com.bezkoder.spring.datajpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Expense;
import com.bezkoder.spring.datajpa.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class FerGetExpenseController {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@GetMapping("/expense/{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable("expenseId") Integer expenseId) {
		Optional<Expense> expense = expenseRepository.findById(expenseId);

		if (expense.isPresent()) {
			return new ResponseEntity<>(expense.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
