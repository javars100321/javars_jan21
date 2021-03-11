package com.rs.fer.expense.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.bean.Expense;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.util.ExpenseUtil;
import com.rs.fer.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	ExpenseUtil expenseUtil;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Override
	public EditExpenseResponse editExpense(EditExpenseRequest request) {
		EditExpenseResponse response = null;
		
		//User is present or not check
		Optional<Expense> expenses = expenseRepository.findById(request.getExpenseId());
		
		if(expenses.isPresent()) {
			
		//load vo to bean
		Expense expense = expenseUtil.loadEditExpenseRequestToExpense(request);
		
		//save bean to database
		expense = expenseRepository.save(expense);
		
		//load response
			//success
			response = new EditExpenseResponse(HttpStatus.OK, 
					"000", "Expense edited successfully", null);
			response.setExpense(expense);
		} else {
			//failure
			response = new EditExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, 
					"002", "expense editing failed", null);
		}
		
		
	
		return response;

}
}
