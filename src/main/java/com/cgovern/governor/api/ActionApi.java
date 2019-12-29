/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cgovern.governor.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgovern.governor.models.BadRequest;
import com.cgovern.governor.models.Pipeline;
import com.cgovern.governor.models.Plan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "{action}", description = "the {action} API")
public interface ActionApi {

	@ApiOperation(value = "Action on a pipeline", nickname = "actionPipelinePipelineIdPost", notes = "", tags = {
			"action", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class) })
	@RequestMapping(value = "/{action}/pipeline/{pipelineId}", produces = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> actionPipelinePipelineIdPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody Pipeline body,
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId,
			@ApiParam(value = "", required = true, allowableValues = "\"run\", \"stop\"") @PathVariable("action") String action);

	@ApiOperation(value = "Action on a pipeline", nickname = "actionPlanPlanIdPost", notes = "", tags = { "action", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class) })
	@RequestMapping(value = "/{action}/plan/{planId}", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> actionPlanPlanIdPost(@ApiParam(value = "", required = true) @Valid @RequestBody Plan body,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true, allowableValues = "\"run\", \"stop\"") @PathVariable("action") String action);

}