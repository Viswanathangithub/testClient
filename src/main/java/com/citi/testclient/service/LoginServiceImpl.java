package com.citi.testclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.testclient.doa.LoginRepository;
import com.citi.testclient.model.UserDetails;
import com.citi.testclient.request.LoginRequest;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private LoginRepository loginRepository;
	
	/**
	 * Search By User Id and Password
	 * @param loginRequest
	 * @return
	 */
	public List<UserDetails> getLoginDetails(LoginRequest loginRequest) {
		return loginRepository.findByCredentials(loginRequest);
	}

}
