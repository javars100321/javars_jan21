package com.rs.fer.expense.util;

import com.rs.fer.bean.Expense;
import com.rs.fer.expense.request.EditExpenseRequest;

public interface ExpenseUtil {
	
	Expense loadEditExpenseRequestToExpense(EditExpenseRequest request);
}
