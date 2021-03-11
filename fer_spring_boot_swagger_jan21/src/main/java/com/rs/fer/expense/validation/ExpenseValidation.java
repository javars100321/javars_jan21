package com.rs.fer.expense.validation;

import java.util.Set;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;

public interface ExpenseValidation {

	Set<String> validateAddExpenseRequest(AddExpenseRequest request);
	Set<String> validateEditExpenseRequest(EditExpenseRequest request);

	Set<String> validateDeleteExpenseRequest(DeleteExpenseRequest request);
}
