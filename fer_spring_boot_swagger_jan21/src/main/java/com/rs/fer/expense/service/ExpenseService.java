package com.rs.fer.expense.service;

import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.response.EditExpenseResponse;

public interface ExpenseService {
	
	EditExpenseResponse editExpense(EditExpenseRequest request);
	
}
