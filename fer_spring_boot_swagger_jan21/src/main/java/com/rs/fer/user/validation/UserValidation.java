package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.RegistrationRequest;

public interface UserValidation {
	
	Set<String> validateRegistrationRequest(RegistrationRequest request);
	Set<String> validateGetUserRequest(int userId);
	
}
