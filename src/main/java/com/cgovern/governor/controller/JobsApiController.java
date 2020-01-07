package com.cgovern.governor.controller;

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

import com.cgovern.governor.api.JobsApi;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class JobsApiController implements JobsApi {

	private static final Logger log = LoggerFactory.getLogger(JobsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final ProjectRepository projectRepository;

	private final PlanRepository planRepository;

	private final StageRepository stageRepository;

	private final JobRepository jobRepository;


//	TODO - Fix Implementation
	
	
	@org.springframework.beans.factory.annotation.Autowired
	public JobsApiController(ObjectMapper objectMapper, HttpServletRequest request,
			ProjectRepository projectRepository, PlanRepository planRepository, StageRepository stageRepository,
			JobRepository jobRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.projectRepository = projectRepository;
		this.planRepository = planRepository;
		this.stageRepository = stageRepository;
		this.jobRepository = jobRepository;
	}

	public ResponseEntity<Job> addJob(
	
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			Stage stage = new Stage();
			List<Index> jobIndexList = new ArrayList<Index>();

			Optional<Stage> optionalStage = stageRepository.findById(stageId);
			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			}
			jobIndexList = stage.getJobs();
			Index jobIndex = new Index();

			Job job = jobRepository.save(body);

			jobIndex.setId(job.getId());
			jobIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(jobIndexList)));

			if (jobIndexList == null) {
				jobIndexList = new ArrayList<Index>();
				jobIndexList.add(jobIndex);
			} else {
				jobIndexList.add(jobIndex);
			}

			stage.setJobs(jobIndexList);
			stageRepository.save(stage);

			return new ResponseEntity<Job>(job, HttpStatus.CREATED);

		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	

	public ResponseEntity<Job> deleteJobById(
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
			Stage stage = new Stage();
			List<Index> jobIndexList = new ArrayList<Index>();

			Optional<Stage> optionalStage = stageRepository.findById(stageId);
			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			}
			jobIndexList = stage.getJobs();

			for (Index currentIndex : jobIndexList) {
				if (currentIndex.getId().equalsIgnoreCase(stageId)) {
					jobIndexList.remove(currentIndex);
				}
			}

			Job job = new Job();

			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			}

			if (jobIndexList == null) {
				jobIndexList = new ArrayList<Index>();
				stage.setJobs(jobIndexList);
				stageRepository.save(stage);
			} else {
				stage.setJobs(jobIndexList);
				stageRepository.save(stage);
			}

			jobRepository.deleteById(jobId);

			return new ResponseEntity<Job>(job, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}


	public ResponseEntity<Job> getJobById(
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		Stage stage = new Stage();
		Job job = new Job();
		if (accept != null && accept.contains("application/json")) {
//			Test
			Optional<Stage> optionalStage = stageRepository.findById(stageId);

			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			}

			Boolean isJobIdexPresent = false;
			if (stage.getJobs() != null) {

				for (Index currentIndex : stage.getJobs()) {
					if (currentIndex.getId().equalsIgnoreCase(jobId)) {
						isJobIdexPresent = true;
					}

				}

				if (isJobIdexPresent) {
					Optional<Job> optionalJob = jobRepository.findById(jobId);
					if (optionalJob.isPresent()) {
						job = optionalJob.get();
					}

					return new ResponseEntity<Job>(job, HttpStatus.OK);
				} else {
					return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Job>> getJobs(
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {

//		Test
		String accept = request.getHeader("Accept");
		List<Job> jobList = new ArrayList<Job>();
		Stage stage = new Stage();
		if (accept != null && accept.contains("application/json")) {
			Optional<Stage> optionalStage = stageRepository.findById(stageId);

			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			}

			if (!stage.getJobs().isEmpty()) {
				List<Index> jobListIndex = stage.getJobs();

				for (Index currentJobIndex : jobListIndex) {
					Job job = new Job();
					Optional<Job> optionalJob = jobRepository.findById(currentJobIndex.getId());

					if (optionalJob.isPresent()) {
						job = optionalJob.get();

						jobList.add(job);
					}

				}

				return new ResponseEntity<List<Job>>(jobList, HttpStatus.OK);

			} else {
				return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<List<Job>>(HttpStatus.NOT_IMPLEMENTED);
	}

	

	public ResponseEntity<Job> updateJobById(
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "Job object", required = true) @Valid @RequestBody Job body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(stageRepository.findById(stageId).get().getProjectid());
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(stageRepository.findById(stageId).get().getPlanid());

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

			Stage stage = new Stage();
			Optional<Stage> optionalStage = stageRepository.findById(stageId);

			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

			Job job = new Job();
			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();

				job.setEnabled(body.isEnabled());
				job.setName(body.getName());
				job.setPlanid(body.getPlanid());
				job.setProjectid(body.getProjectid());
				job.setShortname(body.getShortname());
				job.setStageid(body.getStageid());
				job.setTasks(body.getTasks());
				job.setVariables(body.getVariables());

				jobRepository.save(job);

				return new ResponseEntity<Job>(job, HttpStatus.ACCEPTED);

			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Job>(HttpStatus.NOT_IMPLEMENTED);
	}

	

}
