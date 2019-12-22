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
import com.servec.governor.models.DImage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "dimages", description = "the dimages API")
public interface DimagesApi {

	@ApiOperation(value = "Delete existing Dimage", nickname = "dimagesDimageIdDelete", notes = "", response = DImage.class, tags = {
			"dimage", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = DImage.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/dimages/{dimageId}", method = RequestMethod.DELETE)
	ResponseEntity<DImage> dimagesDimageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId);

	@ApiOperation(value = "Retrieve Existing DImage", nickname = "dimagesDimageIdGet", notes = "", response = DImage.class, tags = {
			"dimage", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = DImage.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/dimages/{dimageId}", method = RequestMethod.GET)
	ResponseEntity<DImage> dimagesDimageIdGet(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId);

	@ApiOperation(value = "Update existing DImage", nickname = "dimagesDimageIdPut", notes = "", response = DImage.class, tags = {
			"dimage", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = DImage.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/dimages/{dimageId}", method = RequestMethod.PUT)
	ResponseEntity<DImage> dimagesDimageIdPut(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId,
			@ApiParam(value = "DImage object", required = true) @Valid @RequestBody DImage body);

	@ApiOperation(value = "Add a DImage", nickname = "dimagesPost", notes = "", response = DImage.class, tags = {
			"dimage", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = DImage.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/dimages", method = RequestMethod.POST)
	ResponseEntity<DImage> dimagesPost(@ApiParam(value = "", required = true) @Valid @RequestBody DImage body);

	@ApiOperation(value = "Retrieve All DImages", nickname = "getDImages", notes = "", response = DImage.class, responseContainer = "List", tags = {
			"dimage", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = DImage.class, responseContainer = "List") })
	@RequestMapping(value = "/dimages", method = RequestMethod.GET)
	ResponseEntity<List<DImage>> getDImages();

}