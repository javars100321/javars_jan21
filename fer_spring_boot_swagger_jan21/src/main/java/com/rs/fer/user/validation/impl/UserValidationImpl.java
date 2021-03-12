package com.rs.fer.user.validation.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.validation.UserValidation;
import com.rs.fer.util.FERUtil;

@Component
public class UserValidationImpl implements UserValidation {

	@Override
	public Set<String> validateRegistrationRequest(RegistrationRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getFirstname(), "Please enter First Name");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getLastname(), "Please enter Lastname");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getEmail(), "Please enter Email");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUsername(), "Please enter Username");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getPassword(), "Please enter Password");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMobile(), "Please enter Mobile");

		return errorMessages;
	}

	@Override
	public Set<String> validateResetPasswordRequest(ResetPasswordRequest request) {

		// errormessages
		return null;
	}

	public static Set<String> addError(Set<String> errorMessages, int value, String errorMessage) {

		if (value <= 0) {
			errorMessages.add(errorMessage);
		}

		return errorMessages;
	}

	@Override
	public Set<String> validateGetUserRequest(int userId) {
		Set<String> errorMessages = new HashSet<String>();

		addError(errorMessages, userId, "Please enter valid userId");

		return errorMessages;
	}

}
