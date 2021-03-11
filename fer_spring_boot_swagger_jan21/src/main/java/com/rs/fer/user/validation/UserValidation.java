package com.rs.fer.user.validation;

import java.util.Set;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;

public interface UserValidation {
	
	Set<String> validateRegistrationRequest(RegistrationRequest request);




	Set<String> validateResetPasswordRequest(ResetPasswordRequest request);

//uservalidation



}
