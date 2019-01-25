package com.citi.testclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.testclient.model.UserDetails;
import com.citi.testclient.request.LoginRequest;
import com.citi.testclient.service.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@RequestMapping(value="/login", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<String> getLoginDetails(@RequestBody (required=true) LoginRequest loginRequest) {
		ResponseEntity<String> responseEntity = null;
		if(StringUtils.isEmpty(loginRequest.getUserName()) || StringUtils.isEmpty(loginRequest.getPassword())) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			List<UserDetails> userDetails = loginServiceImpl.getLoginDetails(loginRequest);
			if(userDetails.size() >0) {
				responseEntity = new ResponseEntity<String>(userDetails.toString(), HttpStatus.OK);
			}
		}
		return responseEntity;
	}
}
