package com.rs.fer.user.util;

import com.rs.fer.bean.User;
import com.rs.fer.user.request.RegistrationRequest;

public interface UserUtil {
	
	User loadRegistrationRequestToUser(RegistrationRequest request);
}
