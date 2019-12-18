package com.servec.governor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.HeartbeatApi;
import com.servec.governor.models.Heartbeat;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T06:26:02.812Z")

@Controller
public class HeartbeatApiController implements HeartbeatApi {

	private static final Logger log = LoggerFactory.getLogger(HeartbeatApiController.class);

	private final ObjectMapper objectMapper;

	@org.springframework.beans.factory.annotation.Autowired
	public HeartbeatApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
	}

	public ResponseEntity<Heartbeat> heartbeatGet() {

		try {
			return new ResponseEntity<Heartbeat>(objectMapper.readValue("{  \"pulse\" : \"ok\"}", Heartbeat.class),
					HttpStatus.NOT_IMPLEMENTED);
		} catch (IOException e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Heartbeat>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
