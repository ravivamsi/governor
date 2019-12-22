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
import com.servec.governor.models.Role;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "roles", description = "the roles API")
public interface RolesApi {

	@ApiOperation(value = "Create New Role", nickname = "addRole", notes = "", response = Role.class, tags = {
			"role", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Role.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/roles", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Role> addRole(@ApiParam(value = "Role object", required = true) @Valid @RequestBody Role body);

	@ApiOperation(value = "Delete existing role", nickname = "deleteRoleById", notes = "", response = Role.class, tags = {
			"role", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Role.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/roles/{roleId}", method = RequestMethod.DELETE)
	ResponseEntity<Role> deleteRoleById(@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId);

	@ApiOperation(value = "Retrieve Existing Role", nickname = "getRoleById", notes = "", response = Role.class, tags = {
			"role", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Role.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/roles/{roleId}", method = RequestMethod.GET)
	ResponseEntity<Role> getRoleById(@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId);

	@ApiOperation(value = "Retrieve All Roles", nickname = "getRoles", notes = "", response = Role.class, responseContainer = "List", tags = {
			"role", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Role.class, responseContainer = "List") })
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	ResponseEntity<List<Role>> getRoles();

	@ApiOperation(value = "Update existing role", nickname = "updateRoleById", notes = "", response = Role.class, tags = {
			"role", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Role.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/roles/{roleId}", method = RequestMethod.PUT)
	ResponseEntity<Role> updateRoleById(@ApiParam(value = "", required = true) @PathVariable("roleId") Long roleId);

}
