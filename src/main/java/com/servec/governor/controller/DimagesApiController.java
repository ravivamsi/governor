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
import com.servec.governor.api.DimagesApi;
import com.servec.governor.models.DImage;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class DimagesApiController implements DimagesApi {

	private static final Logger log = LoggerFactory.getLogger(DimagesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public DimagesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<DImage> dimagesDimageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<DImage>(objectMapper.readValue(
						"{  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"}",
						DImage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<DImage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesDimageIdGet(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<DImage>(objectMapper.readValue(
						"{  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"}",
						DImage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<DImage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesDimageIdPut(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") Long dimageId,
			@ApiParam(value = "DImage object", required = true) @Valid @RequestBody DImage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<DImage>(objectMapper.readValue(
						"{  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"}",
						DImage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<DImage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesPost(@ApiParam(value = "", required = true) @Valid @RequestBody DImage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<DImage>(objectMapper.readValue(
						"{  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"}",
						DImage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<DImage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<DImage>> getDImages() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<DImage>>(objectMapper.readValue(
						"[ {  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"}, {  \"imagename\" : \"imagename\",  \"imageversion\" : \"imageversion\",  \"id\" : 0,  \"imagetag\" : \"imagetag\",  \"shortname\" : \"shortname\"} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<DImage>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<DImage>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
