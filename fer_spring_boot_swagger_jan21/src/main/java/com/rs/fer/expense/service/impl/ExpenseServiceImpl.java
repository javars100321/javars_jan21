package com.rs.fer.expense.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.util.ExpenseUtil;
import com.rs.fer.repository.ExpenseRepository;
import com.rs.fer.repository.UserRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseUtil expenseUtil;

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public EditExpenseResponse editExpense(EditExpenseRequest request) {
		EditExpenseResponse response = null;

		// User is present or not check
		Optional<Expense> expenses = expenseRepository.findById(request.getExpenseId());

		if (expenses.isPresent()) {

			// load vo to bean
			Expense expense = expenseUtil.loadEditExpenseRequestToExpense(request);

			// save bean to database
			expense = expenseRepository.save(expense);

			// load response
			// success
			response = new EditExpenseResponse(HttpStatus.OK, "000", "Expense edited successfully", null);
			response.setExpense(expense);
		} else {
			// failure
			response = new EditExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "expense editing failed", null);
		}

		return response;

	}

	@Override
	public DeleteExpenseResponse deleteExpense(DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;

		// Expense is present or not check
		Optional<Expense> expenses = expenseRepository.findById(request.getExpenseid());

		if (expenses.isPresent()) {

			// load vo to bean
			Expense expense = expenseUtil.loadDeleteExpenseRequestToExpense(request);

			// delete bean to database
			expenseRepository.delete(expense);

			// success
			response = new DeleteExpenseResponse(HttpStatus.OK, "000", "Expense is succesfully Deleted", null);
			response.setExpense(expense);
		} else {
			// failure
			response = new DeleteExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Delete Expense is failed",
					null);
		}

		return response;
	}
	public AddExpenseResponse addExpense(AddExpenseRequest request) {

		AddExpenseResponse response = null;

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {
			// load vo to bean
			Expense expense1 = expenseUtil.loadAddExpenseRequestToExpense(request);
			User user = userObj.get();
			user.getExpenses().add(expense1);
			// save bean to database
			user = userRepository.save(user);

			response = new AddExpenseResponse(HttpStatus.OK, "000", "Expense Added is succesfully ", null);
			response.setExpense(expense1);

		} else {
			// failure
			response = new AddExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}
		return response;

	}
}
