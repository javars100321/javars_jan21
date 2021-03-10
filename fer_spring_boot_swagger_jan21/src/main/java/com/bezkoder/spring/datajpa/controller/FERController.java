package com.bezkoder.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class FERController {

	

	
	@Autowired
	ExpenseRepository expenseRepository;

	
	@DeleteMapping("/expense/{expenseId}")
	public ResponseEntity<HttpStatus> deleteExpense(@PathVariable("expenseId") int expenseId) {

		try {
			expenseRepository.deleteById(expenseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
	
	