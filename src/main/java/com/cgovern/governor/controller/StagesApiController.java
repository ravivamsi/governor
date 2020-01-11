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

import com.cgovern.governor.api.StagesApi;
import com.cgovern.governor.commons.Sequence;
import com.cgovern.governor.models.Index;
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
public class StagesApiController implements StagesApi {

	private static final Logger log = LoggerFactory.getLogger(StagesApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final ProjectRepository projectRepository;

	private final PlanRepository planRepository;

	private final StageRepository stageRepository;

//	TODO - Fix Implementation

	@org.springframework.beans.factory.annotation.Autowired
	public StagesApiController(ObjectMapper objectMapper, HttpServletRequest request,
			ProjectRepository projectRepository, PlanRepository planRepository, StageRepository stageRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.projectRepository = projectRepository;
		this.planRepository = planRepository;
		this.stageRepository = stageRepository;

	}

	public ResponseEntity<Stage> addStage(

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

	public ResponseEntity<List<Stage>> getStages(

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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdGet(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");
		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();
		if (accept != null && accept.contains("application/json")) {
//			Test
			Optional<Project> optionalProject = projectRepository
					.findById(planRepository.findById(planId).get().getProjectid());

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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdDelete(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");

		Project project = new Project();
		Plan plan = new Plan();
		Stage stage = new Stage();

		if (accept != null && accept.contains("application/json")) {
//			Test
			Optional<Project> optionalProject = projectRepository
					.findById(planRepository.findById(planId).get().getProjectid());

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

	public ResponseEntity<Stage> projectsProjectIdPlansPlanIdStagesStageIdPut(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

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
				stage.setProjectid(plan.getProjectid());
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

}
