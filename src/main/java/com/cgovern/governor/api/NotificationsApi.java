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
import com.cgovern.governor.models.Notification;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Api(value = "notifications", description = "the notifications API")
public interface NotificationsApi {

	@ApiOperation(value = "Create New Notification", nickname = "addNotification", notes = "", response = Notification.class, tags = {
			"notification", })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Notification.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 409, message = "Conflict") })
	@RequestMapping(value = "/notifications", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Notification> addNotification(
			@ApiParam(value = "Notification object", required = true) @Valid @RequestBody Notification body);

	@ApiOperation(value = "Retrieve All Notifications", nickname = "getNotifications", notes = "", response = Notification.class, responseContainer = "List", tags = {
			"notification", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Notification.class, responseContainer = "List") })
	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	ResponseEntity<List<Notification>> getNotifications();

	@ApiOperation(value = "Delete existing Notification", nickname = "notificationsNotificationIdDelete", notes = "", response = Notification.class, tags = {
			"notification", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Notification.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/notifications/{notificationId}", method = RequestMethod.DELETE)
	ResponseEntity<Notification> notificationsNotificationIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId);

	@ApiOperation(value = "Retrieve Existing Notification", nickname = "notificationsNotificationIdGet", notes = "", response = Notification.class, tags = {
			"notification", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Notification.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/notifications/{notificationId}", method = RequestMethod.GET)
	ResponseEntity<Notification> notificationsNotificationIdGet(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId);

	@ApiOperation(value = "Update existing Notification", nickname = "notificationsNotificationIdPut", notes = "", response = Notification.class, tags = {
			"notification", })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content", response = Notification.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/notifications/{notificationId}", method = RequestMethod.PUT)
	ResponseEntity<Notification> notificationsNotificationIdPut(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId);

}
