package com.cgovern.governor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cgovern.governor.api.UserApi;
import com.cgovern.governor.models.Login;
import com.cgovern.governor.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class UserApiController implements UserApi {

	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<User> loginUser(@ApiParam(value = "", required = true) @Valid @RequestBody Login body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> logoutUser(
			@ApiParam(value = "The user name for login", required = true) @PathVariable("username") String username) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

}
