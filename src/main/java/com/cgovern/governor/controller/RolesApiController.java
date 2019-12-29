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

import com.cgovern.governor.api.RolesApi;
import com.cgovern.governor.models.Role;
import com.cgovern.governor.models.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class RolesApiController implements RolesApi {

	private static final Logger log = LoggerFactory.getLogger(RolesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final RoleRepository roleRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public RolesApiController(ObjectMapper objectMapper, HttpServletRequest request, RoleRepository roleRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.roleRepository = roleRepository;
	}

	public ResponseEntity<Role> addRole(
			@ApiParam(value = "Role object", required = true) @Valid @RequestBody Role body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<Role>(roleRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> deleteRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") String roleId) {
		String accept = request.getHeader("Accept");
		Role role = new Role();
		if (accept != null && accept.contains("application/json")) {

			Optional<Role> optionalRole = roleRepository.findById(roleId);
			if (optionalRole.isPresent()) {
				role = optionalRole.get();
			}
			roleRepository.deleteById(roleId);
			return new ResponseEntity<Role>(role, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> getRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") String roleId) {
		String accept = request.getHeader("Accept");
		Role role = new Role();
		if (accept != null && accept.contains("application/json")) {
			Optional<Role> optionalRole = roleRepository.findById(roleId);
			if (optionalRole.isPresent()) {
				role = optionalRole.get();
			}

			return new ResponseEntity<Role>(role, HttpStatus.OK);

		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Role>> getRoles() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<List<Role>>(roleRepository.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<List<Role>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Role> updateRoleById(
			@ApiParam(value = "", required = true) @PathVariable("roleId") String roleId,
			@ApiParam(value = "Role object", required = true) @Valid @RequestBody Role body) {
		String accept = request.getHeader("Accept");
		Role role = new Role();
		if (accept != null && accept.contains("application/json")) {
			Optional<Role> optionalRole = roleRepository.findById(roleId);
			if (optionalRole.isPresent()) {
				role = optionalRole.get();
			}

			role.setName(body.getName());
			role.setStatus(body.getStatus());

			roleRepository.save(role);
			return new ResponseEntity<Role>(role, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Role>(HttpStatus.NOT_IMPLEMENTED);
	}

}
