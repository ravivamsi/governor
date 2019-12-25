package com.cgovern.governor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.cgovern.governor.api.StatusApi;
import com.cgovern.governor.commons.Evaluator;
import com.cgovern.governor.commons.MongoConnector;
import com.cgovern.governor.models.Dependency;
import com.cgovern.governor.models.Dependency.StatusEnum;
import com.cgovern.governor.models.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T05:19:56.685Z")

@Controller
public class StatusApiController implements StatusApi {

	private static final Logger log = LoggerFactory.getLogger(StatusApiController.class);

	private final ObjectMapper objectMapper;

	public final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public StatusApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Status> statusGet() {

		List<Dependency> dependencies = new ArrayList<Dependency>();

		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			// MongoDB Component
			Dependency mongoDependency = new Dependency();
			mongoDependency.setId(UUID.randomUUID().toString());
			mongoDependency.setName("Mongo Connection");
			if (MongoConnector.testConnection()) {
				mongoDependency.setStatus(StatusEnum.valueOf("UP"));
			} else {
				mongoDependency.setStatus(StatusEnum.valueOf("DOWN"));
			}

			if (mongoDependency != null) {
				dependencies.add(mongoDependency);
			}

			Status status = new Status();

			status.setId(UUID.randomUUID().toString());
			status.setOverallstatus(Evaluator.overallStatus(dependencies));
			if (!dependencies.isEmpty()) {
				status.setDependencies(dependencies);
			}

			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}

		return new ResponseEntity<Status>(HttpStatus.NOT_IMPLEMENTED);
	}

}
