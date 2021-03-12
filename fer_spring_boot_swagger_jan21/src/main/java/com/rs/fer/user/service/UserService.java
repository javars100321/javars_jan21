package com.rs.fer.user.service;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;

public interface UserService {
	
	RegistrationResponse registration(RegistrationRequest request);

	//ResetPasswordResponse resetPassword(ResetPasswordRequest requestd);

	ResetPasswordResponse resetPassword(ResetPasswordRequest requestd);
	

	GetUserResponse getUser(int userid);
	
}
