package com.rs.fer.expense.service;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.RegistrationResponse;

public interface UserService {
	
	RegistrationResponse registration(RegistrationRequest request);
	
}
