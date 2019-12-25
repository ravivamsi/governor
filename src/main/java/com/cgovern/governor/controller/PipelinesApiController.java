package com.cgovern.governor.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cgovern.governor.api.PipelinesApi;
import com.cgovern.governor.models.Pipeline;
import com.cgovern.governor.models.PipelineRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class PipelinesApiController implements PipelinesApi {

	private static final Logger log = LoggerFactory.getLogger(PipelinesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final PipelineRepository pipelineRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public PipelinesApiController(ObjectMapper objectMapper, HttpServletRequest request,
			PipelineRepository pipelineRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.pipelineRepository = pipelineRepository;
	}

	public ResponseEntity<Pipeline> addPipeline(
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			return new ResponseEntity<Pipeline>(pipelineRepository.save(body), HttpStatus.CREATED);

		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Pipeline>> getPipelines() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			return new ResponseEntity<List<Pipeline>>(pipelineRepository.findAll(), HttpStatus.OK);

		}

		return new ResponseEntity<List<Pipeline>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId) {
		String accept = request.getHeader("Accept");
		Pipeline pipeline = new Pipeline();
		if (accept != null && accept.contains("application/json")) {

			Optional<Pipeline> optionalPipeline = pipelineRepository.findById(pipelineId);
			if (optionalPipeline.isPresent()) {
				pipeline = optionalPipeline.get();
			}
			pipelineRepository.deleteById(pipelineId);
			return new ResponseEntity<Pipeline>(pipeline, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdGet(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId) {
		String accept = request.getHeader("Accept");
		Pipeline pipeline = new Pipeline();
		if (accept != null && accept.contains("application/json")) {

			Optional<Pipeline> optionalPipeline = pipelineRepository.findById(pipelineId);
			if (optionalPipeline.isPresent()) {
				pipeline = optionalPipeline.get();
			}

			return new ResponseEntity<Pipeline>(pipeline, HttpStatus.OK);

		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdPut(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId,
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body) {
		String accept = request.getHeader("Accept");
		Pipeline pipeline = new Pipeline();
		if (accept != null && accept.contains("application/json")) {

			Optional<Pipeline> optionalPipeline = pipelineRepository.findById(pipelineId);
			if (optionalPipeline.isPresent()) {
				pipeline = optionalPipeline.get();
			}

			pipeline.setName(body.getName());
			pipeline.setEnabled(body.isEnabled());
			pipeline.setComponents(body.getComponents());

			return new ResponseEntity<Pipeline>(pipeline, HttpStatus.OK);

		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

}
