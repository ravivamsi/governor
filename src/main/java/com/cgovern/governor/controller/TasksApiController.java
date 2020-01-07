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

import com.cgovern.governor.api.TasksApi;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class TasksApiController implements TasksApi {
	
	
	
//	TODO - Fix Implementation

	private static final Logger log = LoggerFactory.getLogger(TasksApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final ProjectRepository projectRepository;

	private final PlanRepository planRepository;

	private final StageRepository stageRepository;

	private final JobRepository jobRepository;

	private final TaskRepository taskRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public TasksApiController(ObjectMapper objectMapper, HttpServletRequest request,
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

	
	public ResponseEntity<Task> addTask(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			Test
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

	

	public ResponseEntity<List<Task>> getTasks(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		List<Task> taskList = new ArrayList<Task>();
		Job job = new Job();

		if (accept != null && accept.contains("application/json")) {

//			Test

			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			}

			if (!job.getTasks().isEmpty()) {
				List<Index> taskListIndex = job.getTasks();

				for (Index currentTaskIndex : taskListIndex) {
					Task task = new Task();
					Optional<Task> optionalTask = taskRepository.findById(currentTaskIndex.getId());

					if (optionalTask.isPresent()) {
						task = optionalTask.get();

						taskList.add(task);
					}

				}

				return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);

			} else {
				return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
	}

	

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
		String accept = request.getHeader("Accept");

		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();
		Job job = new Job();
		Task task = new Task();
		if (accept != null && accept.contains("application/json")) {
//			TEST
			Optional<Project> optionalProject = projectRepository.findById(taskRepository.findById(jobId).get().getProjectid());

			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			Boolean isPlanIdexPresent = false;
			if (project.getPlans() != null) {

				for (Index currentIndex : project.getPlans()) {
					if (currentIndex.getId().equalsIgnoreCase(taskRepository.findById(jobId).get().getPlanid())) {
						isPlanIdexPresent = true;
					}

				}

				if (isPlanIdexPresent) {
					Optional<Plan> optionalPlan = planRepository.findById(taskRepository.findById(jobId).get().getPlanid());
					if (optionalPlan.isPresent()) {
						plan = optionalPlan.get();
					}

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(taskRepository.findById(jobId).get().getStageid())) {
								isStageIndexPresent = true;
							}

						}
						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(taskRepository.findById(jobId).get().getStageid());
							if (optionalStage.isPresent()) {
								stage = optionalStage.get();

							} else {
								return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
							}

							Boolean isJobIndexPresent = false;

							if (stage.getJobs() != null) {

								for (Index currentJobIndex : stage.getJobs()) {
									if (currentJobIndex.getId().equalsIgnoreCase(jobId)) {
										isJobIndexPresent = true;

									}
								}

								if (isJobIndexPresent) {

									Optional<Job> optionalJob = jobRepository.findById(jobId);

									if (optionalJob.isPresent()) {

										job = optionalJob.get();
									} else {
										return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
									}
								} else {
									return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
								}

								Boolean isTaskIndexPresent = false;
								if (job.getTasks() != null) {

									for (Index currentTaskIndex : job.getTasks()) {

										if (currentTaskIndex.getId().equalsIgnoreCase(taskId)) {
											isTaskIndexPresent = true;

											job.getTasks().remove(currentTaskIndex);
										}

									}

									if (job.getTasks() == null) {
										job.setTasks(new ArrayList<Index>());
										jobRepository.save(job);
									} else {
										jobRepository.save(job);
									}

									if (isTaskIndexPresent) {
										taskRepository.deleteById(taskId);
										return new ResponseEntity<Task>(task, HttpStatus.OK);
									} else {
										return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
									}

								}

							}

						} else {
							return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
						}

					} else {
						return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
					}
				} else {
					return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdGet(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
		String accept = request.getHeader("Accept");

		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();
		Job job = new Job();
		Task task = new Task();
		if (accept != null && accept.contains("application/json")) {
//			TEST
			Optional<Project> optionalProject = projectRepository.findById(taskRepository.findById(jobId).get().getProjectid());

			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			Boolean isPlanIdexPresent = false;
			if (project.getPlans() != null) {

				for (Index currentIndex : project.getPlans()) {
					if (currentIndex.getId().equalsIgnoreCase(taskRepository.findById(jobId).get().getProjectid())) {
						isPlanIdexPresent = true;
					}

				}

				if (isPlanIdexPresent) {
					Optional<Plan> optionalPlan = planRepository.findById(taskRepository.findById(jobId).get().getProjectid());
					if (optionalPlan.isPresent()) {
						plan = optionalPlan.get();
					}

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(taskRepository.findById(jobId).get().getProjectid())) {
								isStageIndexPresent = true;
							}

						}
						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(taskRepository.findById(jobId).get().getProjectid());
							if (optionalStage.isPresent()) {
								stage = optionalStage.get();

							} else {
								return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
							}

							Boolean isJobIndexPresent = false;

							if (stage.getJobs() != null) {

								for (Index currentJobIndex : stage.getJobs()) {
									if (currentJobIndex.getId().equalsIgnoreCase(jobId)) {
										isJobIndexPresent = true;

									}
								}

								if (isJobIndexPresent) {

									Optional<Job> optionalJob = jobRepository.findById(jobId);

									if (optionalJob.isPresent()) {

										job = optionalJob.get();
									} else {
										return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
									}
								} else {
									return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
								}

								Boolean isTaskIndexPresent = false;
								if (job.getTasks() != null) {

									for (Index currentTaskIndex : job.getTasks()) {

										if (currentTaskIndex.getId().equalsIgnoreCase(taskId)) {
											isTaskIndexPresent = true;

										}

										if (isTaskIndexPresent) {
											Optional<Task> optionalTask = taskRepository.findById(taskId);

											if (optionalTask.isPresent()) {
												task = optionalTask.get();
												return new ResponseEntity<Task>(task, HttpStatus.OK);

											} else {
												return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
											}

										}

									}

								}

							}

						} else {
							return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
						}

					} else {
						return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
					}
				} else {
					return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdPut(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(taskRepository.findById(jobId).get().getProjectid());
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(taskRepository.findById(jobId).get().getProjectid());

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Stage stage = new Stage();
			Optional<Stage> optionalStage = stageRepository.findById(taskRepository.findById(jobId).get().getProjectid());

			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Job job = new Job();
			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();

			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Task task = new Task();
			Optional<Task> optionalTask = taskRepository.findById(taskId);

			if (optionalTask.isPresent()) {
				task = optionalTask.get();

				task.setEnabled(body.isEnabled());
				task.setJobid(jobId);
				task.setPlanid(taskRepository.findById(jobId).get().getProjectid());
				task.setName(body.getName());
				task.setProjectid(taskRepository.findById(jobId).get().getProjectid());
				task.setSequence(body.getSequence());
				task.setShortname(body.getShortname());
				task.setStageid(taskRepository.findById(jobId).get().getProjectid());
				task.setVariables(body.getVariables());

				taskRepository.save(task);

				return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);

			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	

}
