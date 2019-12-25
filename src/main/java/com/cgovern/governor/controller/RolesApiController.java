package com.cgovern.governor.controller;

import java.io.IOException;
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

import com.cgovern.governor.api.RolesApi;
import com.cgovern.governor.models.Role;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class RolesApiController implements RolesApi {

	private static final Logger log = LoggerFactory.getLogger(RolesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public RolesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Role> addRole(
			@ApiParam(value = "Role object", required = true) @Valid @RequestBody Role body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Role>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"}", Role.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> deleteRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Role>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"}", Role.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> getRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Role>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"}", Role.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Role>> getRoles() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Role>>(objectMapper.readValue(
						"[ {  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"}, {  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Role>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Role>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> updateRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Role>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"status\" : \"active\"}", Role.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

}
