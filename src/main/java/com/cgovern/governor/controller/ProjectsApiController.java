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

import com.cgovern.governor.api.ProjectsApi;
import com.cgovern.governor.models.Project;
import com.cgovern.governor.models.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class ProjectsApiController implements ProjectsApi {

	private static final Logger log = LoggerFactory.getLogger(ProjectsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final ProjectRepository projectRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ProjectsApiController(ObjectMapper objectMapper, HttpServletRequest request,
			ProjectRepository projectRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.projectRepository = projectRepository;

	}

	public ResponseEntity<Project> addProject(
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			return new ResponseEntity<Project>(projectRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Project>> getProjects() throws JsonMappingException, JsonProcessingException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			return new ResponseEntity<List<Project>>(projectRepository.findAll(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId) {

		Project project = new Project();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Project>(new Project(), HttpStatus.NOT_FOUND);
			}

//			TODO - Check if you need to delete plans in project.getPlans()
			projectRepository.deleteById(projectId);
			return new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId) {

		Project project = new Project();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
				return new ResponseEntity<Project>(project, HttpStatus.OK);
			} else {
				return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
			}
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdPut(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test

			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
			}

			project.setEnabled(body.isEnabled());
			project.setName(body.getName());
			project.setShortname(body.getShortname());
//			project.setPlans(body.getPlans());
			project.setVariables(body.getVariables());
			project.setGroups(body.getGroups());

			projectRepository.save(project);

			return new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

}
