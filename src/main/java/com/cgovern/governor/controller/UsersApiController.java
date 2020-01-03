package com.cgovern.governor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cgovern.governor.api.UsersApi;
import com.cgovern.governor.models.User;
import com.cgovern.governor.models.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class UsersApiController implements UsersApi {

	private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final UserRepository userRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request, UserRepository userRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.userRepository = userRepository;
	}

	public ResponseEntity<User> createUser(
			@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body) {
		String accept = request.getHeader("Accept");

		if (accept != null && accept.contains("application/json")) {
			List<User> userList = userRepository.findAll();

			for (User currentUser : userList) {
				if (currentUser.getUsername().equalsIgnoreCase(body.getUsername())) {
					return new ResponseEntity<User>(HttpStatus.CONFLICT);
				}
			}
			return new ResponseEntity<User>(userRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> deleteUser(
			@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username) {
		String accept = request.getHeader("Accept");

		User user = new User();
		if (accept != null && accept.contains("application/json")) {
			List<User> userList = userRepository.findAll();

			for (User currentUser : userList) {
				if (currentUser.getUsername().equalsIgnoreCase(username)) {
					user = currentUser;
				}
			}

			userRepository.deleteById(user.getId());
			;
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> getUserByName(
			@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username) {
		String accept = request.getHeader("Accept");
		User user = new User();
		if (accept != null && accept.contains("application/json")) {

			List<User> userList = userRepository.findAll();

			for (User currentUser : userList) {
				if (currentUser.getUsername().equalsIgnoreCase(username)) {
					user = currentUser;
				}
			}

			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> updateUser(
			@ApiParam(value = "name that need to be updated", required = true) @PathVariable("username") String username,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body) {
		String accept = request.getHeader("Accept");
		User user = new User();
		if (accept != null && accept.contains("application/json")) {

			List<User> userList = userRepository.findAll();

			for (User currentUser : userList) {
				if (currentUser.getUsername().equalsIgnoreCase(username)) {
					user = currentUser;
				}
			}

			user.setEmail(body.getEmail());
			user.setFirstName(body.getFirstName());
			user.setLastName(body.getLastName());
			user.setPassword(body.getPassword());
			user.setPhone(body.getPhone());
			user.setRoles(body.getRoles());
			user.setStatus(body.getStatus());
			user.setTier(body.getTier());

			userRepository.save(user);
			return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	public ResponseEntity<Void> getUserNameAvailability(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true)
	@PathVariable("username") String username) {
//		TODO
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
