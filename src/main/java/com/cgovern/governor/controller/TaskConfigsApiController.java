/**
 * 
 */
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

import com.cgovern.governor.api.TaskConfigsApi;
import com.cgovern.governor.models.TaskConfig;

/**
 * @author vamsiravi
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T04:54:06.978Z")

@Controller
public class TaskConfigsApiController implements TaskConfigsApi {

	private static final Logger log = LoggerFactory.getLogger(TaskConfigsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TaskConfigsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<List<TaskConfig>> getTaskConfigs() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<TaskConfig>>(objectMapper.readValue(
						"[ {  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"}, {  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<TaskConfig>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<TaskConfig>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody TaskConfig body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<TaskConfig>(objectMapper.readValue(
						"{  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"}",
						TaskConfig.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<TaskConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<TaskConfig>(objectMapper.readValue(
						"{  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"}",
						TaskConfig.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<TaskConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdGet(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<TaskConfig>(objectMapper.readValue(
						"{  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"}",
						TaskConfig.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<TaskConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdPut(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId,
			@ApiParam(value = "taskconfig object", required = true) @Valid @RequestBody TaskConfig body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<TaskConfig>(objectMapper.readValue(
						"{  \"schema\" : [ {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  }, {    \"fieldkey\" : \"fieldkey\",    \"fielddefaultvalue\" : \"fielddefaultvalue\",    \"description\" : \"description\",    \"fieldvaluetype\" : \"string\",    \"fieldvalueformat\" : \"fieldvalueformat\",    \"id\" : \"id\",    \"required\" : true  } ],  \"name\" : \"name\",  \"dimageid\" : \"dimageid\",  \"id\" : \"id\"}",
						TaskConfig.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<TaskConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

}
