package com.servec.governor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.NotificationsApi;
import com.servec.governor.models.Notification;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class NotificationsApiController implements NotificationsApi {

	private static final Logger log = LoggerFactory.getLogger(NotificationsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public NotificationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Notification> addNotification(
			@ApiParam(value = "Notification object", required = true) @Valid @RequestBody Notification body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Notification>(objectMapper.readValue(
						"{  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true}",
						Notification.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Notification>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Notification>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Notification>> getNotifications() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Notification>>(objectMapper.readValue(
						"[ {  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true}, {  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Notification>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Notification>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Notification> notificationsNotificationIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Notification>(objectMapper.readValue(
						"{  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true}",
						Notification.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Notification>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Notification>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Notification> notificationsNotificationIdGet(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Notification>(objectMapper.readValue(
						"{  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true}",
						Notification.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Notification>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Notification>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Notification> notificationsNotificationIdPut(
			@ApiParam(value = "", required = true) @PathVariable("notificationId") Long notificationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Notification>(objectMapper.readValue(
						"{  \"name\" : \"name\",  \"id\" : 0,  \"to\" : \"to\",  \"type\" : \"type\",  \"enabled\" : true}",
						Notification.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Notification>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Notification>(HttpStatus.NOT_IMPLEMENTED);
	}

}
