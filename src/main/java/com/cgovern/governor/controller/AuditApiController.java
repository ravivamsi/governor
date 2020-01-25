package com.cgovern.governor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cgovern.governor.api.AuditApi;
import com.cgovern.governor.models.Audit;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class AuditApiController implements AuditApi {

	private static final Logger log = LoggerFactory.getLogger(AuditApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AuditApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Audit> retrieveAudit(
			@ApiParam(value = "AuditId object that needs to retrieved", required = true) @PathVariable("auditId") String auditId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
//            	TODO
				return new ResponseEntity<Audit>(objectMapper.readValue(
						"{  \"change\" : [ {    \"sequence\" : 0,    \"new\" : \"new\",    \"level\" : \"plan\",    \"old\" : \"old\",    \"type\" : \"create\",    \"key\" : \"key\",    \"timestamp\" : \"timestamp\"  }, {    \"sequence\" : 0,    \"new\" : \"new\",    \"level\" : \"plan\",    \"old\" : \"old\",    \"type\" : \"create\",    \"key\" : \"key\",    \"timestamp\" : \"timestamp\"  } ],  \"planId\" : \"planId\",  \"id\" : \"id\"}",
						Audit.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Audit>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Audit>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> updateAudit(
			@ApiParam(value = "AuditId object that needs to retrieved", required = true) @PathVariable("auditId") String auditId,
			@ApiParam(value = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Audit body) {
		String accept = request.getHeader("Accept");

//        TODO
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
