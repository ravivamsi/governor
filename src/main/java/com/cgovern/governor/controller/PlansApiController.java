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

import com.cgovern.governor.api.PlansApi;
import com.cgovern.governor.commons.Sequence;
import com.cgovern.governor.models.Index;
import com.cgovern.governor.models.Plan;
import com.cgovern.governor.models.PlanRepository;
import com.cgovern.governor.models.Project;
import com.cgovern.governor.models.ProjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Controller
public class PlansApiController implements PlansApi {

	private static final Logger log = LoggerFactory.getLogger(PlansApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final ProjectRepository projectRepository;

	private final PlanRepository planRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public PlansApiController(ObjectMapper objectMapper, HttpServletRequest request,
			ProjectRepository projectRepository, PlanRepository planRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.projectRepository = projectRepository;
		this.planRepository = planRepository;

	}

	public ResponseEntity<Plan> addPlan(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Project project = new Project();
			List<Index> planIndexList = new ArrayList<Index>();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				project = optionalProject.get();
				
				planIndexList = project.getPlans();
				Index planIndex = new Index();
					
				body.setProjectid(projectId);
				
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
				
			}else {
				return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
			}
			

		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Plan>> getPlans(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId) {
		String accept = request.getHeader("Accept");
		List<Plan> planList = new ArrayList<Plan>();
		Project project = new Project();
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Optional<Project> optionalProject = projectRepository.findById(projectId);

			if (optionalProject.isPresent()) {
				project = optionalProject.get();
				
				
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
				
			}else {
				return new ResponseEntity<List<Plan>>(HttpStatus.NOT_FOUND);
			}

			

		}

		return new ResponseEntity<List<Plan>>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Plan> deletePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Project project = new Project();
			Plan plan = new Plan();
			
			List<Index> planIndexList = new ArrayList<Index>();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			if (optionalProject.isPresent()) {
				
				project = optionalProject.get();
				
				
				if(!project.getPlans().isEmpty()) {
					planIndexList = project.getPlans();
					
					for (Index currentIndex : planIndexList) {
						if (currentIndex.getId().equalsIgnoreCase(planId)) {
							planIndexList.remove(currentIndex);
						}
					}
					
					Optional<Plan> optionalPlan = planRepository.findById(planId);
					if (optionalPlan.isPresent()) {
						plan = optionalPlan.get();
						
						
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
						
					}else {
						return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
					}

					
				}else {
					return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
				}
			
				
			}else {
				return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
			}
			
			
			
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> getPlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");
		Plan plan = new Plan();
		Project project = new Project();
		if (accept != null && accept.contains("application/json")) {
			
//			TODO - Test

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			
			if (optionalProject.isPresent()) {
				
				project = optionalProject.get();
				
				if(!project.getPlans().isEmpty()) {
					
					Optional<Plan> optionalPlan = planRepository.findById(planId);
					
					if (optionalPlan.isPresent() ) {
						
						plan = optionalPlan.get();
						
						return new ResponseEntity<Plan>(plan, HttpStatus.OK);
												
					}else {
						return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
					}

					
				}else {
					return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
				}
			
				
			}else {
				return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
			}
			
			
			
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Plan> updatePlanById(
			@ApiParam(value = "", required = true) @PathVariable("projectId") String projectId,
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "Plan object", required = true) @Valid @RequestBody Plan body) {
		String accept = request.getHeader("Accept");
		Project project = new Project();
		
		Plan plan = new Plan();
		
		if (accept != null && accept.contains("application/json")) {
			
//			TODO - Test
			
			List<Index> planIndexList = new ArrayList<Index>();

			Optional<Project> optionalProject = projectRepository.findById(projectId);
			
			if (optionalProject.isPresent()) {
				
				project = optionalProject.get();
				
				if(!project.getPlans().isEmpty()) {
					planIndexList = project.getPlans();
					
					Optional<Plan> optionalPlan = planRepository.findById(planId);
					
					if (optionalPlan.isPresent() ) {
						
						plan = optionalPlan.get();
						
						plan.setEnabled(body.isEnabled());
						plan.setName(body.getName());
						plan.setEnvironment(body.getEnvironment());
						plan.setStages(body.getStages());
						plan.setShortname(body.getShortname());
						plan.setVariables(body.getVariables());
						plan.setType(body.getType());
						planRepository.save(plan);
						
						return new ResponseEntity<Plan>(plan, HttpStatus.OK);
												
					}else {
						return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
					}

					
				}else {
					return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
				}
			
				
			}else {
				return new ResponseEntity<Plan>(new Plan(), HttpStatus.NOT_FOUND);
			}
		
		}

		return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
	}

}
