package com.servec.governor.controller;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.TriggersApi;
import com.servec.governor.models.Trigger;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class TriggersApiController implements TriggersApi {

	private static final Logger log = LoggerFactory.getLogger(TriggersApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TriggersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Trigger> addTrigger(
			@ApiParam(value = "Trigger object", required = true) @Valid @RequestBody Trigger body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Trigger>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}", Trigger.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Trigger>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> deleteTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Trigger>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}", Trigger.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Trigger>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> getTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Trigger>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}", Trigger.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Trigger>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Trigger>> getTriggers() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Trigger>>(objectMapper.readValue(
						"[ {  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}, {  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Trigger>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Trigger>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> updateTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Trigger>(objectMapper
						.readValue("{  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}", Trigger.class),
						HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Trigger>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

}
