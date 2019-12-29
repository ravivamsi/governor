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

import com.cgovern.governor.api.ActionApi;
import com.cgovern.governor.models.Pipeline;
import com.cgovern.governor.models.PipelineRepository;
import com.cgovern.governor.models.Plan;
import com.cgovern.governor.models.PlanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class ActionApiController implements ActionApi {

	private static final Logger log = LoggerFactory.getLogger(ActionApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final PipelineRepository pipelineRepository;

	private final PlanRepository planRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ActionApiController(ObjectMapper objectMapper, HttpServletRequest request,
			PipelineRepository pipelineRepository, PlanRepository planRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.pipelineRepository = pipelineRepository;
		this.planRepository = planRepository;
	}

	public ResponseEntity<Void> actionPipelinePipelineIdPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody Pipeline body,
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId,
			@ApiParam(value = "", required = true, allowableValues = "\"run\", \"stop\"") @PathVariable("action") String action) {
		String accept = request.getHeader("Accept");

//        TODO

		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> actionPlanPlanIdPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody Plan body,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true, allowableValues = "\"run\", \"stop\"") @PathVariable("action") String action) {
		String accept = request.getHeader("Accept");

		Plan plan = new Plan();

//      TODO

		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
