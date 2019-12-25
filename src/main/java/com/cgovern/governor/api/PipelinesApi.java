/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cgovern.governor.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgovern.governor.models.BadRequest;
import com.cgovern.governor.models.Pipeline;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "pipelines", description = "the pipelines API")
public interface PipelinesApi {

	@ApiOperation(value = "Create New Pipeline", nickname = "addPipeline", notes = "", response = Pipeline.class, tags = {
			"pipeline", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Pipeline.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/pipelines", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Pipeline> addPipeline(
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body);

	@ApiOperation(value = "Retrieve All Pipeline", nickname = "getPipelines", notes = "", response = Pipeline.class, responseContainer = "List", tags = {
			"pipeline", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Pipeline.class, responseContainer = "List") })
	@RequestMapping(value = "/pipelines", method = RequestMethod.GET)
	ResponseEntity<List<Pipeline>> getPipelines();

	@ApiOperation(value = "Delete existing Pipeline", nickname = "pipelinesPipelineIdDelete", notes = "", response = Pipeline.class, tags = {
			"pipeline", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Pipeline.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/pipelines/{pipelineId}", method = RequestMethod.DELETE)
	ResponseEntity<Pipeline> pipelinesPipelineIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId);

	@ApiOperation(value = "Retrieve Existing Pipeline", nickname = "pipelinesPipelineIdGet", notes = "", response = Pipeline.class, tags = {
			"pipeline", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Pipeline.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/pipelines/{pipelineId}", method = RequestMethod.GET)
	ResponseEntity<Pipeline> pipelinesPipelineIdGet(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId);

	@ApiOperation(value = "Update existing Pipeline", nickname = "pipelinesPipelineIdPut", notes = "", response = Pipeline.class, tags = {
			"pipeline", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Pipeline.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/pipelines/{pipelineId}", method = RequestMethod.PUT)
	ResponseEntity<Pipeline> pipelinesPipelineIdPut(
			@ApiParam(value = "", required = true) @PathVariable("pipelineId") String pipelineId,
			@ApiParam(value = "Pipeline object", required = true) @Valid @RequestBody Pipeline body);

}
