package com.rs.fer.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.bean.User;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserUtil userUtil;

	@Autowired
	UserRepository userRepository;

	@Override
	public RegistrationResponse registration(RegistrationRequest request) {
		RegistrationResponse response = null;

		// User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(users)) {
			// User already present
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given email address", null);
			return response;
		}

		// load vo to bean
		User user = userUtil.loadRegistrationRequestToUser(request);

		// save bean to database
		user = userRepository.save(user);

		// load response
		if (user.getUserId() > 0) {
			// success
			response = new RegistrationResponse(HttpStatus.OK, "000", "User is succesfully registered", null);
			response.setUser(user);
		} else {
			// failure
			response = new RegistrationResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User registration is failed",
					null);
		}

		return response;
		//return null;
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		ResetPasswordResponse response = null;
		Optional<User> userObj = userRepository.findById(request.getUserId());
		if (userObj.isPresent()) {
			User user = userObj.get();
			if (user.getPassword().equals(request.getCurrentPassword())) {
				
				// success
				user.setPassword(request.getNewPassword());
				userRepository.save(user);
				response = new ResetPasswordResponse(HttpStatus.OK, "000", "password changed successfully", null);
			} else {
				
				// failure
				
				response = new ResetPasswordResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
						"Current Password and password which is on the account are not matching", null);

			}

		} else {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "001", "User is not foiund", null);
		}
		return response;
	}

}
