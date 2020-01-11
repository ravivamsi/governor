package com.cgovern.governor.controller;

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

import com.cgovern.governor.api.GroupsApi;
import com.cgovern.governor.models.Group;
import com.cgovern.governor.models.GroupRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class GroupsApiController implements GroupsApi {

	private static final Logger log = LoggerFactory.getLogger(GroupsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final GroupRepository groupRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public GroupsApiController(ObjectMapper objectMapper, HttpServletRequest request,
			GroupRepository groupRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.groupRepository = groupRepository;
	}

	public ResponseEntity<Group> addGroup(
			@ApiParam(value = "Group object", required = true) @Valid @RequestBody Group body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<Group>(groupRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Group>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Group> deleteGroupById(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId) {
		String accept = request.getHeader("Accept");
		Group group = new Group();
		if (accept != null && accept.contains("application/json")) {

			Optional<Group> optionalGroup = groupRepository.findById(groupId);
			if (optionalGroup.isPresent()) {
				group = optionalGroup.get();
			}
			groupRepository.deleteById(groupId);
			return new ResponseEntity<Group>(group, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Group>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Group> getGroupById(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId) {
		String accept = request.getHeader("Accept");
		Group group = new Group();
		if (accept != null && accept.contains("application/json")) {
			Optional<Group> optionalGroup = groupRepository.findById(groupId);
			if (optionalGroup.isPresent()) {
				group = optionalGroup.get();
			}

			return new ResponseEntity<Group>(group, HttpStatus.OK);

		}

		return new ResponseEntity<Group>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Group>> getGroups() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<List<Group>>(groupRepository.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<List<Group>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Group> updateGroupById(
			@ApiParam(value = "", required = true) @PathVariable("groupId") String groupId,
			@ApiParam(value = "Group object", required = true) @Valid @RequestBody Group body) {
		String accept = request.getHeader("Accept");
		Group group = new Group();
		if (accept != null && accept.contains("application/json")) {
			Optional<Group> optionalGroup = groupRepository.findById(groupId);
			if (optionalGroup.isPresent()) {
				group = optionalGroup.get();
			}

//			TODO
			group.setName(body.getName());

			groupRepository.save(group);
			return new ResponseEntity<Group>(group, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Group>(HttpStatus.NOT_IMPLEMENTED);
	}

}
