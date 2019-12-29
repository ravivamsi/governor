package com.cgovern.governor.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.cgovern.governor.commons.Sequence;
import com.cgovern.governor.models.Index;
import com.cgovern.governor.models.Job;
import com.cgovern.governor.models.JobRepository;
import com.cgovern.governor.models.Plan;
import com.cgovern.governor.models.PlanRepository;
import com.cgovern.governor.models.Project;
import com.cgovern.governor.models.ProjectRepository;
import com.cgovern.governor.models.Stage;
import com.cgovern.governor.models.StageRepository;
import com.cgovern.governor.models.Task;
import com.cgovern.governor.models.TaskRepository;
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

	private final PlanRepository planRepository;

	private final StageRepository stageRepository;

	private final JobRepository jobRepository;

	private final TaskRepository taskRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ProjectsApiController(ObjectMapper objectMapper, HttpServletRequest request,
			ProjectRepository projectRepository, PlanRepository planRepository, StageRepository stageRepository,
			JobRepository jobRepository, TaskRepository taskRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.projectRepository = projectRepository;
		this.planRepository = planRepository;
		this.stageRepository = stageRepository;
		this.jobRepository = jobRepository;
		this.taskRepository = taskRepository;
	}

	public ResponseEntity<Job> addJob(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> addPlan(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			Project project = new Project();
			List<Index> planIndexList = new ArrayList<Index>();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}
			planIndexList = project.getPlans();
			Index planIndex = new Index();

			Plan plan = planRepository.save(body);

			planIndex.setId(plan.getId());
			planIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(planIndexList)));

			if (planIndexList == null) {
				planIndexList = new ArrayList<Index>();
				planIndexList.add(planIndex);
			} else {
				planIndexList.add(planIndex);
			}

			project.setPlans(planIndexList);
			projectRepository.save(project);

			return new ResponseEntity<Plan>(plan, HttpStatus.CREATED);

		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Project> addProject(
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			return new ResponseEntity<Project>(projectRepository.save(body), HttpStatus.CREATED);
		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> addStage(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
			Plan plan = new Plan();
			List<Index> stageIndexList = new ArrayList<Index>();
			Optional<Plan> optionalPlan = planRepository.findById(planId);
			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			}
			stageIndexList = plan.getStages();
			Index stageIndex = new Index();

			Stage stage = stageRepository.save(body);

			stageIndex.setId(plan.getId());
			stageIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(stageIndexList)));
			stageIndexList.add(stageIndex);
			plan.setStages(stageIndexList);
			planRepository.save(plan);

			return new ResponseEntity<Stage>(stage, HttpStatus.CREATED);

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> addTask(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
			Job job = new Job();
			List<Index> taskIndexList = new ArrayList<Index>();
			Optional<Job> optionalJob = jobRepository.findById(jobId);
			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			}
			taskIndexList = job.getTasks();
			Index taskIndex = new Index();

			Task task = taskRepository.save(body);

			taskIndex.setId(job.getId());
			taskIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(taskIndexList)));
			taskIndexList.add(taskIndex);
			job.setTasks(taskIndexList);
			jobRepository.save(job);

			return new ResponseEntity<Task>(task, HttpStatus.CREATED);

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> deleteJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
			Job job = new Job();

			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			}

			jobRepository.deleteById(jobId);

			return new ResponseEntity<Job>(job, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> deletePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			Project project = new Project();
			List<Index> planIndexList = new ArrayList<Index>();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}
			planIndexList = project.getPlans();

			for (Index currentIndex : planIndexList) {
				if (currentIndex.getId().equalsIgnoreCase(planId)) {
					planIndexList.remove(currentIndex);
				}
			}
			Plan plan = new Plan();

			Optional<Plan> optionalPlan = planRepository.findById(planId);
			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			}

			if (planIndexList == null) {
				planIndexList = new ArrayList<Index>();
				project.setPlans(planIndexList);
				projectRepository.save(project);
			} else {
				project.setPlans(planIndexList);
				projectRepository.save(project);
			}

			planRepository.deleteById(planId);

			return new ResponseEntity<Plan>(plan, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> getJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");
		Plan plan = new Plan();
		Project project = new Project();
		if (accept != null && accept.contains("application/json")) {
//			Test
			Optional<Project> optionalProject = projectRepository.findById(projectId);

			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			Boolean isPlanIdexPresent = false;
			if (project.getPlans() != null) {

				for (Index currentIndex : project.getPlans()) {
					if (currentIndex.getId().equalsIgnoreCase(planId)) {
						isPlanIdexPresent = true;
					}

				}

				if (isPlanIdexPresent) {
					Optional<Plan> optionalPlan = planRepository.findById(planId);
					if (optionalPlan.isPresent()) {
						plan = optionalPlan.get();
					}

					return new ResponseEntity<Plan>(plan, HttpStatus.OK);
				} else {
					return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Plan>> getPlans(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO

			return new ResponseEntity<List<Plan>>(planRepository.findAll(), HttpStatus.NOT_IMPLEMENTED);

		}

		return new ResponseEntity<List<Plan>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Project>> getProjects() throws JsonMappingException, JsonProcessingException {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			return new ResponseEntity<List<Project>>(projectRepository.findAll(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Project>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Stage>> getStages(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String proStringId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId) {

		Project project = new Project();
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

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
//			Test
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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
//		TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "Project object", required = true) @Valid @RequestBody Project body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test

			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			project.setEnabled(body.isEnabled());
			project.setName(body.getName());
			project.setShortname(body.getShortname());
			project.setPlans(body.getPlans());
			project.setVariables(body.getVariables());

			projectRepository.save(project);

			return new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Project>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Job> updateJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO
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
