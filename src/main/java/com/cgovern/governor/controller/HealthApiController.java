package com.cgovern.governor.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.cgovern.governor.api.HealthApi;
import com.cgovern.governor.models.Health;
import com.fasterxml.jackson.databind.ObjectMapper;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T06:26:02.812Z")

@Controller
public class HealthApiController implements HealthApi {

	private static final Logger log = LoggerFactory.getLogger(HealthApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public HealthApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Health> healthGet() {
		String accept = request.getHeader("Accept");
		Health health = new Health();
		if (accept != null && accept.contains("application/json")) {
//			TODO
//			Need a way to get the Build Number, BuildTime and Version set during the build time

			health.setAppname("CGovern");
			health.setBuildnumber("3");
			health.setBuildtime(String.valueOf(System.currentTimeMillis()));
			health.setReleasetime(String.valueOf(System.currentTimeMillis()));
			health.setVersion("0.0.3");

			return new ResponseEntity<Health>(health, HttpStatus.OK);
		}

		return new ResponseEntity<Health>(HttpStatus.NOT_IMPLEMENTED);
	}

}
