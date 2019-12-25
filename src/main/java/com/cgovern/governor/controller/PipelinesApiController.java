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

import com.cgovern.governor.api.PipelinesApi;
import com.cgovern.governor.models.Pipeline;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class PipelinesApiController implements PipelinesApi {

	private static final Logger log = LoggerFactory.getLogger(PipelinesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PipelinesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Pipeline> addPipeline(
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Pipeline>(objectMapper.readValue(
						"{  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}",
						Pipeline.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Pipeline>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Pipeline>> getPipelines() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Pipeline>>(objectMapper.readValue(
						"[ {  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}, {  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Pipeline>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Pipeline>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") Long pipelineId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Pipeline>(objectMapper.readValue(
						"{  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}",
						Pipeline.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Pipeline>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdGet(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") Long pipelineId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Pipeline>(objectMapper.readValue(
						"{  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}",
						Pipeline.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Pipeline>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Pipeline> pipelinesPipelineIdPut(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") Long pipelineId,
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Pipeline>(objectMapper.readValue(
						"{  \"components\" : [ {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  }, {    \"sequence\" : 1,    \"id\" : 6,    \"type\" : \"plan\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"enabled\" : true}",
						Pipeline.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Pipeline>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Pipeline>(HttpStatus.NOT_IMPLEMENTED);
	}

}
