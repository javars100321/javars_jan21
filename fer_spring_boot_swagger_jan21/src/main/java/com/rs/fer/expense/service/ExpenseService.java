package com.rs.fer.expense.service;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;

public interface ExpenseService {

	EditExpenseResponse editExpense(EditExpenseRequest request);

	DeleteExpenseResponse deleteExpense(DeleteExpenseRequest request);
	AddExpenseResponse addExpense(AddExpenseRequest request);


}
