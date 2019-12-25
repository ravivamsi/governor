package com.servec.governor.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.ProjectsApi;
import com.servec.governor.models.Job;
import com.servec.governor.models.Plan;
import com.servec.governor.models.Project;
import com.servec.governor.models.ProjectRepository;
import com.servec.governor.models.Stage;
import com.servec.governor.models.Task;

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

	public ResponseEntity<Job> addJob(@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Job>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Job.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> addPlan(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Plan>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Plan.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Plan>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> addProject(
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			body.setId(UUID.randomUUID());
			return new ResponseEntity<Project>(projectRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> addStage(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Stage>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Stage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Stage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> addTask(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Task>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Task.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> deleteJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Job>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Job.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> deletePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Plan>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Plan.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Plan>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> getJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Job>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Job.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Job>> getJobs(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Job>>(objectMapper.readValue(
						"[ {  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}, {  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Job>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Job>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> getPlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Plan>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Plan.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Plan>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Plan>> getPlans(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Plan>>(objectMapper.readValue(
						"[ {  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true}, {  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Plan>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Plan>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Project>> getProjects() throws JsonMappingException, JsonProcessingException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<List<Project>>(projectRepository.findAll(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Stage>> getStages(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Stage>>(objectMapper.readValue(
						"[ {  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}, {  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Stage>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Stage>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Task>> getTasks(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Task>>(objectMapper.readValue(
						"[ {  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}, {  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") UUID projectId) {

//		TODO
//		Test this before closing - Issue with retrieving

		Project project = new Project();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			Optional<Project> optionalProject = projectRepository.findById(projectId.toString());
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			projectRepository.deleteById(projectId.toString());
			return new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") UUID projectId) {
//		TODO
//		Test this before closing - Issue with retrieving
		Project project = new Project();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Optional<Project> optionalProject = projectRepository.findById(projectId.toString());
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
				return new ResponseEntity<Project>(project, HttpStatus.OK);
			} else {
				return new ResponseEntity<Project>(project, HttpStatus.NOT_FOUND);
			}
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Stage>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Stage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Stage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Stage>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Stage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Stage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") Long taskId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Task>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Task.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") Long taskId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Task>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Task.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdPut(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") Long taskId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Task>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Task.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdPut(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Stage>(objectMapper.readValue(
						"{  \"sequence\" : 6,  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Stage.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Stage>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> projectsProjectIdPut(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Project>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Project.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> updateJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") Long stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") Long jobId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Job>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Job.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> updatePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") Long projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") Long planId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Plan>(objectMapper.readValue(
						"{  \"variables\" : [ {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  }, {    \"id\" : 6,    \"value\" : \"value\",    \"key\" : \"key\"  } ],  \"name\" : \"name\",  \"id\" : 0,  \"type\" : \"build\",  \"shortname\" : \"shortname\",  \"enabled\" : true}",
						Plan.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Plan>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

}
