/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.servec.governor.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servec.governor.models.BadRequest;
import com.servec.governor.models.Trigger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "triggers", description = "the triggers API")
public interface TriggersApi {

	@ApiOperation(value = "Create New Trigger", nickname = "addTrigger", notes = "", response = Trigger.class, tags = {
			"trigger", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Trigger.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/triggers", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Trigger> addTrigger(
			@ApiParam(value = "Trigger object", required = true) @Valid @RequestBody Trigger body);

	@ApiOperation(value = "Delete existing Trigger", nickname = "deleteTriggerById", notes = "", response = Trigger.class, tags = {
			"trigger", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Trigger.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/triggers/{triggerId}", method = RequestMethod.DELETE)
	ResponseEntity<Trigger> deleteTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId);

	@ApiOperation(value = "Retrieve Existing Trigger", nickname = "getTriggerById", notes = "", response = Trigger.class, tags = {
			"trigger", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Trigger.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/triggers/{triggerId}", method = RequestMethod.GET)
	ResponseEntity<Trigger> getTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId);

	@ApiOperation(value = "Retrieve All Triggers", nickname = "getTriggers", notes = "", response = Trigger.class, responseContainer = "List", tags = {
			"trigger", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Trigger.class, responseContainer = "List") })
	@RequestMapping(value = "/triggers", method = RequestMethod.GET)
	ResponseEntity<List<Trigger>> getTriggers();

	@ApiOperation(value = "Update existing Trigger", nickname = "updateTriggerById", notes = "", response = Trigger.class, tags = {
			"role", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Trigger.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/triggers/{triggerId}", method = RequestMethod.PUT)
	ResponseEntity<Trigger> updateTriggerById(
			@ApiParam(value = "", required = true) @PathVariable("triggerId") Long triggerId);

}
