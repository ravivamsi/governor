package com.cgovern.governor.controller;

import java.util.Date;

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
import com.cgovern.governor.commons.Crypt;
import com.cgovern.governor.models.Login;
import com.cgovern.governor.models.Session;
import com.cgovern.governor.models.Session.StatusEnum;
import com.cgovern.governor.models.SessionRepository;
import com.cgovern.governor.models.User;
import com.cgovern.governor.models.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class UserApiController implements UserApi {

	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final SessionRepository sessionRepository;

	private final UserRepository userRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request, SessionRepository sessionRepository,
			UserRepository userRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.sessionRepository = sessionRepository;
		this.userRepository = userRepository;
	}

	public ResponseEntity<Session> loginUser(@ApiParam(value = "", required = true) @Valid @RequestBody Login body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			User user = userRepository.findByTheUsersUsername(body.getUsername());

//			Test Functionality

			if (Crypt.decodeCreds(body.getUsername(), user.getPassword()).equals(body.getPassword())) {

				Session session = sessionRepository.findSessionByUsername(body.getUsername());

				if (session != null) {
					return new ResponseEntity<Session>(session, HttpStatus.OK);
				} else {

					Date currentDate = new Date();
					session = new Session();
					session.setEndtime(currentDate.toString());
					session.setExpires(900);
					session.setStarttime(currentDate.toString());
					session.setStatus(StatusEnum.ACTIVE);
					session.setToken(Crypt.encodeCreds(body.getUsername(), user.getEmail() + currentDate.toString()));
					session.setUsername(body.getUsername());

					sessionRepository.save(session);

					return new ResponseEntity<Session>(session, HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<Session>(new Session(), HttpStatus.BAD_REQUEST);
			}

		}

		return new ResponseEntity<Session>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> logoutUser(
			@ApiParam(value = "The user name for login", required = true) @PathVariable("username") String username) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

//			Test Functionality
			User user = userRepository.findByTheUsersUsername(username);

			if (user != null) {
				Session session = sessionRepository.findSessionByUsername(user.getUsername());

				if (session != null) {
					sessionRepository.deleteById(session.getId());
					return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
				} else {
					return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
				}

			} else {
				return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
			}

		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

}
