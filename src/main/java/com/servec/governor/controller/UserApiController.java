package com.servec.governor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.UserApi;
import com.servec.governor.models.Login;
import com.servec.governor.models.User;

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
			try {
				return new ResponseEntity<User>(objectMapper.readValue(
						"{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"password\" : \"password\",  \"tier\" : \"enterprise\",  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\",  \"status\" : \"active\"}",
						User.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> logoutUser(
			@ApiParam(value = "The user name for login", required = true) @PathVariable("username") String username) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<User>(objectMapper.readValue(
						"{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"password\" : \"password\",  \"tier\" : \"enterprise\",  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\",  \"status\" : \"active\"}",
						User.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

}