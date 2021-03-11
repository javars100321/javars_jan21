package com.rs.fer.expense.validation;

import java.util.Set;

import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;

public interface ExpenseValidation {

	Set<String> validateEditExpenseRequest(EditExpenseRequest request);

	Set<String> validateDeleteExpenseRequest(DeleteExpenseRequest request);
}
