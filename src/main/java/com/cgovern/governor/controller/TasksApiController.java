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

	private final JobRepository jobRepository;

	private final TaskRepository taskRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public TasksApiController(ObjectMapper objectMapper, HttpServletRequest request,
			
			JobRepository jobRepository, TaskRepository taskRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.jobRepository = jobRepository;
		this.taskRepository = taskRepository;
	}

	public ResponseEntity<Task> addTask(@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		
		Job job = new Job();
		
		Task task = new Task();
		
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			
			List<Index> taskIndexList = new ArrayList<Index>();
			
			Optional<Job> optionalJob = jobRepository.findById(jobId);
			if (optionalJob.isPresent()) {
				
				job = optionalJob.get();
			
				taskIndexList = job.getTasks();
				Index taskIndex = new Index();
				
				body.setProjectid(job.getProjectid());
				body.setPlanid(job.getPlanid());
				body.setStageid(job.getStageid());
				body.setJobid(jobId);
				
				task = taskRepository.save(body);
				
				
				taskIndex.setId(task.getId());
				taskIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(taskIndexList)));
				
				if(taskIndexList == null) {
					taskIndexList = new ArrayList<Index>();
					taskIndexList.add(taskIndex);
				}else {
					taskIndexList.add(taskIndex);
				}
				
				job.setTasks(taskIndexList);
				jobRepository.save(job);
				
				return new ResponseEntity<Task>(task, HttpStatus.CREATED);
			
			}else {
				return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Task>> getTasks(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId) {
		String accept = request.getHeader("Accept");
		
		List<Task> taskList = new ArrayList<Task>();
		Job job = new Job();

		if (accept != null && accept.contains("application/json")) {

//			TODO - Test

			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			
			
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
			
			}else {
				return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> jobsJobIdTasksTaskIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
		String accept = request.getHeader("Accept");

		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Job job = new Job();
			Task task = new Task();
			
			List<Index> taskIndexList = new ArrayList<Index>();

			Optional<Job> optionalJob = jobRepository.findById(jobId);
			if (optionalJob.isPresent()) {
				job = optionalJob.get();

				if(!job.getTasks().isEmpty()) {
					
					taskIndexList = job.getTasks();
					
					
					for (Index currentIndex: taskIndexList) {
						
						if(currentIndex.getId().equalsIgnoreCase(taskId)) {
							taskIndexList.remove(currentIndex);
						}
					
					}
					
					Optional<Task> optionalTask = taskRepository.findById(taskId);
					
					if(optionalTask.isPresent()) {
						
						task = optionalTask.get();
						
						if(taskIndexList == null) {
							taskIndexList = new ArrayList<Index>();
							job.setTasks(taskIndexList);
							jobRepository.save(job);
						}else {
							job.setTasks(taskIndexList);
							jobRepository.save(job);
						}
						
						taskRepository.deleteById(taskId);
						
						return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
						
					}else {
						return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
					}
					
					
					
				}else {
					return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
				}
			
			}else {
				return new ResponseEntity<Task>(new Task(),HttpStatus.NOT_FOUND);
			}
			
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> jobsJobIdTasksTaskIdGet(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId) {
		String accept = request.getHeader("Accept");

		Job job = new Job();
		Task task = new Task();
		if (accept != null && accept.contains("application/json")) {
			
//			TODO - Test
			
			Optional<Job> optionalJob = jobRepository.findById(jobId);

			if (optionalJob.isPresent()) {
				job = optionalJob.get();
			
				if(!job.getTasks().isEmpty()) {
					
					Optional<Task> optionalTask = taskRepository.findById(taskId);
					
					if(optionalTask.isPresent()) {
						
						task = optionalTask.get();
						
						return new ResponseEntity<Task>(task, HttpStatus.OK);
						
					}else {
						return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
					}
					
				}else {
					return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
				}
							
			}else {
				return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Task> jobsJobIdTasksTaskIdPut(
			@ApiParam(value = "", required = true) @PathVariable("jobId") String jobId,
			@ApiParam(value = "", required = true) @PathVariable("taskId") String taskId,
			@ApiParam(value = "Task object", required = true) @Valid @RequestBody Task body) {
		String accept = request.getHeader("Accept");
		
		Job job = new Job();
		
		Task task = new Task();
		
		
		if (accept != null && accept.contains("application/json")) {
			
//			TODO - Test
			
			List<Index> taskListIndex = new ArrayList<Index>();
			
			Optional<Job> optionalJob = jobRepository.findById(jobId);
			
			if(optionalJob.isPresent()) {
				
				job = optionalJob.get();
				
				if(!job.getTasks().isEmpty()) {
					
					taskListIndex = job.getTasks();
					
					Optional<Task> optionalTask = taskRepository.findById(taskId);
					
					if(optionalTask.isPresent()) {
						
						task = optionalTask.get();
						
						task.setCondition(body.getCondition());
						task.setConfiguration(body.getConfiguration());
						task.setEnabled(body.isEnabled());
						task.setName(body.getName());
						task.setSequence(body.getSequence());
						task.setShortname(body.getShortname());
						task.setVariables(body.getVariables());

						taskRepository.save(task);

						return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
						
					}else {
						return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
					}
	
				}else {
					return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
				}
				
			}else {
				return new ResponseEntity<Task>(new Task(), HttpStatus.NOT_FOUND);
			}
						
		}

		return new ResponseEntity<Task>(HttpStatus.NOT_IMPLEMENTED);
	}

}
