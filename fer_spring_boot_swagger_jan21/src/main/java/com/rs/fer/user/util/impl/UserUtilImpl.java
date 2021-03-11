package com.rs.fer.user.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.bean.User;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.util.UserUtil;
import com.rs.fer.util.DateUtil;

@Component
public class UserUtilImpl implements UserUtil{

	@Override
	public User loadRegistrationRequestToUser(RegistrationRequest request) {

		User user = new User();
		//user
		
		user.setFirstname(request.getFirstname());
		user.setMiddlename(request.getMiddlename());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setMobile(request.getMobile());
		
		user.setCreated(DateUtil.getCurrentDate());
		
		return user;
	}

	@Override
	public User loadResetPasswordRequestToUser(ResetPasswordRequest request) {
		
      
		
		return null;
	}

}
