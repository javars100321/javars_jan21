package com.rs.fer.user.util;

import com.rs.fer.bean.User;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;

public interface UserUtil {
	
	User loadRegistrationRequestToUser(RegistrationRequest request);
	
	User loadResetPasswordRequestToUser(ResetPasswordRequest request);
}
