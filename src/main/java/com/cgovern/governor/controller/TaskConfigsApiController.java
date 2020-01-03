/**
 * 
 */
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

import com.cgovern.governor.api.TaskConfigsApi;
import com.cgovern.governor.models.TaskConfig;
import com.cgovern.governor.models.TaskConfigRepository;

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

	private final TaskConfigRepository taskConfigRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public TaskConfigsApiController(ObjectMapper objectMapper, HttpServletRequest request,
			TaskConfigRepository taskConfigRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.taskConfigRepository = taskConfigRepository;
	}

	public ResponseEntity<List<TaskConfig>> getTaskConfigs() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			return new ResponseEntity<List<TaskConfig>>(taskConfigRepository.findAll(), HttpStatus.OK);

		}

		return new ResponseEntity<List<TaskConfig>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody TaskConfig body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			return new ResponseEntity<TaskConfig>(taskConfigRepository.save(body), HttpStatus.CREATED);

		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") String taskconfigId) {
		String accept = request.getHeader("Accept");
		TaskConfig taskConfig = new TaskConfig();
		if (accept != null && accept.contains("application/json")) {

			Optional<TaskConfig> optionalTaskConfig = taskConfigRepository.findById(taskconfigId);
			if (optionalTaskConfig.isPresent()) {
				taskConfig = optionalTaskConfig.get();
			}
			taskConfigRepository.deleteById(taskconfigId);
			return new ResponseEntity<TaskConfig>(taskConfig, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdGet(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") String taskconfigId) {
		String accept = request.getHeader("Accept");
		TaskConfig taskConfig = new TaskConfig();
		if (accept != null && accept.contains("application/json")) {

			Optional<TaskConfig> optionalWorker = taskConfigRepository.findById(taskconfigId);
			if (optionalWorker.isPresent()) {
				taskConfig = optionalWorker.get();
			}

			return new ResponseEntity<TaskConfig>(taskConfig, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<TaskConfig> taskconfigsTaskconfigIdPut(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") String taskconfigId,
			@ApiParam(value = "taskconfig object", required = true) @Valid @RequestBody TaskConfig body) {
		String accept = request.getHeader("Accept");
		TaskConfig taskConfig = new TaskConfig();
		if (accept != null && accept.contains("application/json")) {

			Optional<TaskConfig> optionalTaskConfig = taskConfigRepository.findById(taskconfigId);
			if (optionalTaskConfig.isPresent()) {
				taskConfig = optionalTaskConfig.get();
			}

			taskConfig.setDimageid(body.getDimageid());
			taskConfig.setName(body.getName());
			taskConfig.setSchema(body.getSchema());

			taskConfigRepository.save(taskConfig);

			return new ResponseEntity<TaskConfig>(taskConfig, HttpStatus.OK);

		}

		return new ResponseEntity<TaskConfig>(HttpStatus.NOT_IMPLEMENTED);
	}

}
