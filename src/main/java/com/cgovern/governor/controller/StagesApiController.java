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

	private final PlanRepository planRepository;

	private final StageRepository stageRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public StagesApiController(ObjectMapper objectMapper, HttpServletRequest request, PlanRepository planRepository,
			StageRepository stageRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.planRepository = planRepository;
		this.stageRepository = stageRepository;

	}

	public ResponseEntity<Stage> addStage(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");
		Plan plan = new Plan();
		Stage stage = new Stage();
		if (accept != null && accept.contains("application/json")) {
//			TODO - Test

			List<Index> stageIndexList = new ArrayList<Index>();

			Optional<Plan> optionalPlan = planRepository.findById(planId);
			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();

				stageIndexList = plan.getStages();
				Index stageIndex = new Index();

				body.setPlanid(planId);
				body.setProjectid(plan.getProjectid());
				body.setPlanid(plan.getId());

				stage = stageRepository.save(body);

				stageIndex.setId(stage.getId());
				stageIndex.setSequence(Sequence.generateNextSequence(Sequence.getLastUsed(stageIndexList)));

				if (stageIndexList == null) {
					stageIndexList = new ArrayList<Index>();
					stageIndexList.add(stageIndex);
				} else {
					stageIndexList.add(stageIndex);
				}

				plan.setStages(stageIndexList);
				planRepository.save(plan);

				return new ResponseEntity<Stage>(stage, HttpStatus.CREATED);

			} else {
				return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Stage>> getStages(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId) {
		String accept = request.getHeader("Accept");

		List<Stage> stageList = new ArrayList<Stage>();
		Plan plan = new Plan();

		if (accept != null && accept.contains("application/json")) {

//			TODO - Test

			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();

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
			} else {
				return new ResponseEntity<List<Stage>>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<List<Stage>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> deleteStageByPlanIdAndId(
			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");

		if (accept != null && accept.contains("application/json")) {
//			TODO - Test
			Plan plan = new Plan();
			Stage stage = new Stage();

			List<Index> stageIndexList = new ArrayList<Index>();

			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();

				if (!plan.getStages().isEmpty()) {
					stageIndexList = plan.getStages();

					for (Index currentIndex : stageIndexList) {
						if (currentIndex.getId().equalsIgnoreCase(stageId)) {
							stageIndexList.remove(currentIndex);
						}
					}

					Optional<Stage> optionalStage = stageRepository.findById(stageId);
					if (optionalStage.isPresent()) {
						stage = optionalStage.get();

						if (stageIndexList == null) {
							stageIndexList = new ArrayList<Index>();
							plan.setStages(stageIndexList);
							planRepository.save(plan);
						} else {
							plan.setStages(stageIndexList);
							planRepository.save(plan);
						}

						stageRepository.deleteById(stageId);

						return new ResponseEntity<Stage>(stage, HttpStatus.ACCEPTED);

					} else {
						return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
					}

				} else {
					return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> plansPlanIdStagesStageIdGet(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId) {
		String accept = request.getHeader("Accept");

		Plan plan = new Plan();
		Stage stage = new Stage();

		if (accept != null && accept.contains("application/json")) {

//			TODO - Test

			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {

				plan = optionalPlan.get();

				if (!plan.getStages().isEmpty()) {

					Optional<Stage> optionalStage = stageRepository.findById(stageId);

					if (optionalStage.isPresent()) {

						stage = optionalStage.get();

						return new ResponseEntity<Stage>(stage, HttpStatus.OK);

					} else {
						return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
					}

				} else {
					return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Stage> plansPlanIdStagesStageIdPut(

			@ApiParam(value = "", required = true) @PathVariable("planId") String planId,
			@ApiParam(value = "", required = true) @PathVariable("stageId") String stageId,
			@ApiParam(value = "Stage object", required = true) @Valid @RequestBody Stage body) {
		String accept = request.getHeader("Accept");

		Plan plan = new Plan();
		Stage stage = new Stage();

		if (accept != null && accept.contains("application/json")) {

//			TODO - Test

			List<Index> stageIndexList = new ArrayList<Index>();

			Optional<Plan> optionalPlan = planRepository.findById(planId);

			if (optionalPlan.isPresent()) {
				plan = optionalPlan.get();

				if (!plan.getStages().isEmpty()) {

					stageIndexList = plan.getStages();

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

					} else {
						return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
					}

				} else {
					return new ResponseEntity<Stage>(new Stage(), HttpStatus.NOT_FOUND);
				}

			} else {
				return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<Stage>(HttpStatus.NOT_IMPLEMENTED);
	}

}
