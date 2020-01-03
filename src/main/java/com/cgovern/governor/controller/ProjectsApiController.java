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
//			Test
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

	public ResponseEntity<Job> deleteJobById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
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

//		Test
		String accept = request.getHeader("Accept");
		List<Plan> planList = new ArrayList<Plan>();
		Project project = new Project();
		if (accept != null && accept.contains("application/json")) {
			Optional<Project> optionalProject = projectRepository.findById(projectId);

			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			}

			if (!project.getPlans().isEmpty()) {
				List<Index> planListIndex = project.getPlans();

				for (Index currentPlanIndex : planListIndex) {
					Plan plan = new Plan();
					Optional<Plan> optionalPlan = planRepository.findById(currentPlanIndex.getId());

					if (optionalPlan.isPresent()) {
						plan = optionalPlan.get();

						planList.add(plan);
					}

				}

				return new ResponseEntity<List<Plan>>(planList, HttpStatus.OK);

			} else {
				return new ResponseEntity<List<Plan>>(HttpStatus.NOT_FOUND);
			}

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

		List<Stage> stageList = new ArrayList<Stage>();
		Plan plan = new Plan();

		if (accept != null && accept.contains("application/json")) {

//			Test

			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			}

			if (!plan.getStages().isEmpty()) {
				List<Index> stageListIndex = plan.getStages();

				for (Index currentStageIndex : stageListIndex) {
					Stage stage = new Stage();
					Optional<Stage> optionalStage = stageRepository.findById(currentStageIndex.getId());

					if (optionalStage.isPresent()) {
						stage = optionalStage.get();

						stageList.add(stage);
					}

				}

				return new ResponseEntity<List<Stage>>(stageList, HttpStatus.OK);

			} else {
				return new ResponseEntity<List<Stage>>(HttpStatus.NOT_FOUND);
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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");
		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();
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

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(stageId)) {
								isStageIndexPresent = true;
							}

						}
						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(stageId);
							if (optionalStage.isPresent()) {
								stage = optionalStage.get();
								return new ResponseEntity<Stage>(stage, HttpStatus.OK);
							} else {
								return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
							}

						} else {
							return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
						}

					}
				} else {
					return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
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
		String accept = request.getHeader("Accept");

		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();
		Job job = new Job();
		Task task = new Task();
		if (accept != null && accept.contains("application/json")) {
//			TEST
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

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(stageId)) {
								isStageIndexPresent = true;
							}

						}
						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(stageId);
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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");

		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();

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

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(stageId)) {
								isStageIndexPresent = true;
								plan.getStages().remove(currentStageIndex);
								plan.setStages(plan.getStages());

							}

						}

						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(stageId);

							if (optionalStage.isPresent()) {
								stage = optionalStage.get();
							}

							stageRepository.deleteById(stageId);

							return new ResponseEntity<Stage>(stage, HttpStatus.ACCEPTED);

						} else {
							return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
						}

					}
				} else {
					return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> projectsProjectIdPlansPlanIdStagesStageIdJobsJobIdTasksTaskIdGet(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
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

					Boolean isStageIndexPresent = false;

					if (plan.getStages() != null) {
						for (Index currentStageIndex : plan.getStages()) {

							if (currentStageIndex.getId().equalsIgnoreCase(stageId)) {
								isStageIndexPresent = true;
							}

						}
						if (isStageIndexPresent) {

							Optional<Stage> optionalStage = stageRepository.findById(stageId);
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
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
			}

			Stage stage = new Stage();
			Optional<Stage> optionalStage = stageRepository.findById(stageId);

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
				task.setPlanid(planId);
				task.setName(body.getName());
				task.setProjectid(projectId);
				task.setSequence(body.getSequence());
				task.setShortname(body.getShortname());
				task.setStageid(stageId);
				task.setVariables(body.getVariables());

				taskRepository.save(task);

				return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);

			} else {
				return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
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
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();
			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
			}

			Stage stage = new Stage();
			Optional<Stage> optionalStage = stageRepository.findById(stageId);

			if (optionalStage.isPresent()) {
				stage = optionalStage.get();

				stage.setEnabled(body.isEnabled());
				stage.setJobs(body.getJobs());
				stage.setName(body.getName());
				stage.setPlanid(planId);
				stage.setProjectid(projectId);
				stage.setSequence(body.getSequence());
				stage.setShortname(body.getShortname());
				stage.setVariables(body.getVariables());

				stageRepository.save(stage);

				return new ResponseEntity<Stage>(stage, HttpStatus.ACCEPTED);

			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
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
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(planId);

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

	public ResponseEntity<Plan> updatePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Project project = new Project();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
			} else {
				return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
			}

			Plan plan = new Plan();
			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();

				plan.setEnabled(body.isEnabled());
				plan.setName(body.getName());
				plan.setEnvironment(body.getEnvironment());
				plan.setStages(body.getStages());
				plan.setShortname(body.getShortname());
				plan.setVariables(body.getVariables());
				plan.setType(body.getType());
				planRepository.save(plan);
			} else {
				return new ResponseEntity<Plan>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<Plan>(plan, HttpStatus.ACCEPTED);

		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

}
