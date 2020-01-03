/**
 * 
 */
package com.cgovern.governor.api;

import java.util.List;

import javax.validation.Valid;

/**
 * @author vamsiravi
 *
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgovern.governor.models.BadRequest;
import com.cgovern.governor.models.TaskConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T04:54:06.978Z")

@Api(value = "taskconfigs", description = "the taskconfigs API")
public interface TaskConfigsApi {

	@ApiOperation(value = "Retrieve All Task Configs", nickname = "getTaskConfigs", notes = "", response = TaskConfig.class, responseContainer = "List", tags = {
			"taskconfig", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = TaskConfig.class, responseContainer = "List") })
	@RequestMapping(value = "/taskconfigs", method = RequestMethod.GET)
	ResponseEntity<List<TaskConfig>> getTaskConfigs();

	@ApiOperation(value = "Add a Task Config", nickname = "taskconfigsPost", notes = "", response = TaskConfig.class, tags = {
			"taskconfig", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TaskConfig.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/taskconfigs", method = RequestMethod.POST)
	ResponseEntity<TaskConfig> taskconfigsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody TaskConfig body);

	@ApiOperation(value = "Delete existing Task Config", nickname = "taskconfigsTaskconfigIdDelete", notes = "", response = TaskConfig.class, tags = {
			"taskconfig", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = TaskConfig.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/taskconfigs/{taskconfigId}", method = RequestMethod.DELETE)
	ResponseEntity<TaskConfig> taskconfigsTaskconfigIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId);

	@ApiOperation(value = "Retrieve Task Config", nickname = "taskconfigsTaskconfigIdGet", notes = "", response = TaskConfig.class, tags = {
			"taskconfig", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TaskConfig.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/taskconfigs/{taskconfigId}", method = RequestMethod.GET)
	ResponseEntity<TaskConfig> taskconfigsTaskconfigIdGet(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId);

	@ApiOperation(value = "Update existing Task Config", nickname = "taskconfigsTaskconfigIdPut", notes = "", response = TaskConfig.class, tags = {
			"taskconfig", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = TaskConfig.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/taskconfigs/{taskconfigId}", method = RequestMethod.PUT)
	ResponseEntity<TaskConfig> taskconfigsTaskconfigIdPut(
			@ApiParam(value = "", required = true) @PathVariable("taskconfigId") Long taskconfigId,
			@ApiParam(value = "taskconfig object", required = true) @Valid @RequestBody TaskConfig body);

}
