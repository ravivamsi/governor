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

import com.cgovern.governor.api.TriggersApi;
import com.cgovern.governor.models.Trigger;
import com.cgovern.governor.models.TriggerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class TriggersApiController implements TriggersApi {

	private static final Logger log = LoggerFactory.getLogger(TriggersApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final TriggerRepository triggerRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public TriggersApiController(ObjectMapper objectMapper, HttpServletRequest request,
			TriggerRepository triggerRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.triggerRepository = triggerRepository;
	}

	public ResponseEntity<Trigger> addTrigger(
			@ApiParam(value = "Trigger object", required = true) @Valid @RequestBody Trigger body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<Trigger>(triggerRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> deleteTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") String triggerId) {
		String accept = request.getHeader("Accept");
		Trigger trigger = new Trigger();
		if (accept != null && accept.contains("application/json")) {

			Optional<Trigger> optionalDImage = triggerRepository.findById(triggerId);
			if (optionalDImage.isPresent()) {
				trigger = optionalDImage.get();
			}
			triggerRepository.deleteById(triggerId);
			return new ResponseEntity<Trigger>(trigger, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> getTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") String triggerId) {
		String accept = request.getHeader("Accept");
		Trigger trigger = new Trigger();
		if (accept != null && accept.contains("application/json")) {
			Optional<Trigger> optionalTrigger = triggerRepository.findById(triggerId);
			if (optionalTrigger.isPresent()) {
				trigger = optionalTrigger.get();
			}

			return new ResponseEntity<Trigger>(trigger, HttpStatus.OK);

		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Trigger>> getTriggers() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<List<Trigger>>(triggerRepository.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<List<Trigger>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Trigger> updateTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") String triggerId,
			@ApiParam(value = "Trigger object", required = true) @Valid @RequestBody Trigger body) {
		String accept = request.getHeader("Accept");
		Trigger trigger = new Trigger();
		if (accept != null && accept.contains("application/json")) {
			Optional<Trigger> optionalTrigger = triggerRepository.findById(triggerId);
			if (optionalTrigger.isPresent()) {
				trigger = optionalTrigger.get();
			}

			trigger.setEnabled(body.isEnabled());
			trigger.setName(body.getName());

			triggerRepository.save(trigger);
			return new ResponseEntity<Trigger>(trigger, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Trigger>(HttpStatus.NOT_IMPLEMENTED);
	}

}
