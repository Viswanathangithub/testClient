package com.citi.testclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.testclient.model.UserDetails;
import com.citi.testclient.request.LoginRequest;
import com.citi.testclient.service.LoginServiceImpl;

@RestController
@RequestMapping("/users")
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<String> getLoginDetails(@RequestBody (required=true) LoginRequest loginRequest) {
		ResponseEntity<String> responseEntity = null;
		if(StringUtils.isEmpty(loginRequest.getUserId()) || StringUtils.isEmpty(loginRequest.getPassword())) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			List<UserDetails> userDetails = loginServiceImpl.getLoginDetails(loginRequest);
			if(!userDetails.isEmpty()) {
				responseEntity = new ResponseEntity<>(userDetails.toString(), HttpStatus.OK);
			}
		}
		return responseEntity;
	}
}
