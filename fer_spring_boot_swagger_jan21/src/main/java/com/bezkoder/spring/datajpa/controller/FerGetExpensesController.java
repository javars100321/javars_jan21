package com.bezkoder.spring.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Expense;
import com.bezkoder.spring.datajpa.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class FerGetExpensesController {

	@Autowired
	ExpenseRepository expenseRepository;

	@GetMapping("getExpenses/{userid}")
	public List<Expense> getExpenseByUserId(@PathVariable("userid") Integer userid) {
		return expenseRepository.findAll();
	}
}
