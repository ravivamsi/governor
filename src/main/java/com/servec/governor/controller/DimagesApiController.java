package com.servec.governor.controller;

import java.util.List;
import java.util.Optional;

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
import com.servec.governor.models.DImageRepository;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class DimagesApiController implements DimagesApi {

	private static final Logger log = LoggerFactory.getLogger(DimagesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final DImageRepository dimageRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public DimagesApiController(ObjectMapper objectMapper, HttpServletRequest request,
			DImageRepository dimageRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.dimageRepository = dimageRepository;
	}

	public ResponseEntity<DImage> dimagesDimageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") String dimageId) {
		String accept = request.getHeader("Accept");
		DImage dimage = new DImage();

		if (accept != null && accept.contains("application/json")) {

			Optional<DImage> optionalDImage = dimageRepository.findById(dimageId);
			if (optionalDImage.isPresent()) {
				dimage = optionalDImage.get();
			}
			dimageRepository.deleteById(dimageId);
			return new ResponseEntity<DImage>(dimage, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesDimageIdGet(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") String dimageId) {
		DImage dimage = new DImage();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Optional<DImage> optionalDImage = dimageRepository.findById(dimageId);
			if (optionalDImage.isPresent()) {
				dimage = optionalDImage.get();
			}

			return new ResponseEntity<DImage>(dimage, HttpStatus.OK);

		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesDimageIdPut(
			@ApiParam(value = "", required = true) @PathVariable("dimageId") String dimageId,
			@ApiParam(value = "DImage object", required = true) @Valid @RequestBody DImage body) {
		String accept = request.getHeader("Accept");
		DImage dimage = new DImage();
		if (accept != null && accept.contains("application/json")) {
			Optional<DImage> optionalDImage = dimageRepository.findById(dimageId);
			if (optionalDImage.isPresent()) {
				dimage = optionalDImage.get();
			}

			dimage.setImageid(body.getImageid());
			dimage.setImagename(body.getImagename());
			dimage.setImagetag(body.getImagetag());
			dimage.setImageversion(body.getImageversion());
			dimage.setShortname(body.getShortname());

			dimageRepository.save(dimage);
			return new ResponseEntity<DImage>(dimage, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<DImage> dimagesPost(@ApiParam(value = "", required = true) @Valid @RequestBody DImage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<DImage>(dimageRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<DImage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<DImage>> getDImages() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<List<DImage>>(dimageRepository.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<List<DImage>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
