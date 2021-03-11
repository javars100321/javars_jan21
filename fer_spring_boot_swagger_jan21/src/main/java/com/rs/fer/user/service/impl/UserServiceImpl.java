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
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.util.UserUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserUtil userUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public RegistrationResponse registration(RegistrationRequest request) {
		RegistrationResponse response = null;
		
		//User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());
		
		if(!CollectionUtils.isEmpty(users)) {
			//User already present
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, 
					"001", "User is already registered with the given email address", null);
			return response;
		}
		
		//load vo to bean
		User user = userUtil.loadRegistrationRequestToUser(request);
		
		//save bean to database
		user = userRepository.save(user);
		
		//load response
		if(user.getUserId() > 0) {
			//success
			response = new RegistrationResponse(HttpStatus.OK, 
					"000", "User is succesfully registered", null);
			response.setUser(user);
		} else {
			//failure
			response = new RegistrationResponse(HttpStatus.INTERNAL_SERVER_ERROR, 
					"002", "User registration is failed", null);
		}
		
		return response;
	}
	
	@Override
	public GetUserResponse getUser(int userid) {
		GetUserResponse response = null;
		Optional<User> userObj = userRepository.findById(userid);
		if (userObj.isPresent()) {
			response = new GetUserResponse(HttpStatus.OK, "000", "get User is succesfully ", null);
			response.setUser(userObj.get());

		} else {
			response = new GetUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get user is failed", null);

		}

		return response;
	}

}



