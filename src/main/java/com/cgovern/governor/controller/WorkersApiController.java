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

import com.cgovern.governor.api.WorkersApi;
import com.cgovern.governor.commons.Sequence;
import com.cgovern.governor.models.Worker;
import com.cgovern.governor.models.WorkerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-25T23:34:55.664Z")

@Controller
public class WorkersApiController implements WorkersApi {

    private static final Logger log = LoggerFactory.getLogger(WorkersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private final WorkerRepository workerRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public WorkersApiController(ObjectMapper objectMapper, HttpServletRequest request, WorkerRepository workerRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.workerRepository = workerRepository;
    }

    public ResponseEntity<List<Worker>> getWorkers() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

			return new ResponseEntity<List<Worker>>(workerRepository.findAll(), HttpStatus.OK);

		}

        return new ResponseEntity<List<Worker>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Worker> workersPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Worker body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	
			return new ResponseEntity<Worker>(workerRepository.save(body), HttpStatus.CREATED);

        }

        return new ResponseEntity<Worker>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Worker> workersWorkerIdDelete(@ApiParam(value = "",required=true) @PathVariable("workerId") String workerId) {
        String accept = request.getHeader("Accept");
        
        Worker worker = new Worker();
        if (accept != null && accept.contains("application/json")) {
        	
			Optional<Worker> optionalWorker = workerRepository.findById(workerId);
			if (optionalWorker.isPresent()) {
				worker = optionalWorker.get();
			}
			workerRepository.deleteById(workerId);
			return new ResponseEntity<Worker>(worker, HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<Worker>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Worker> workersWorkerIdGet(@ApiParam(value = "",required=true) @PathVariable("workerId") String workerId) {
        String accept = request.getHeader("Accept");
        Worker worker = new Worker();
        if (accept != null && accept.contains("application/json")) {
        	
			Optional<Worker> optionalWorker = workerRepository.findById(workerId);
			if (optionalWorker.isPresent()) {
				worker = optionalWorker.get();
			}

			return new ResponseEntity<Worker>(worker, HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<Worker>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Worker> workersWorkerIdPut(@ApiParam(value = "",required=true) @PathVariable("workerId") String workerId,@ApiParam(value = "Worker object" ,required=true )  @Valid @RequestBody Worker body) {
        String accept = request.getHeader("Accept");
        Worker worker = new Worker();
        if (accept != null && accept.contains("application/json")) {

			Optional<Worker> optionalPipeline = workerRepository.findById(workerId);
			if (optionalPipeline.isPresent()) {
				worker = optionalPipeline.get();
			}

			worker.setHostname(body.getHostname());
			worker.setIpaddr(body.getIpaddr());
			worker.setPassword(body.getPassword());
			worker.setStatus(body.getStatus());
			worker.setUsername(body.getUsername());
			worker.setSequence( Sequence.generateNextSequence( Sequence.getLastUsedWorkerSequence(workerRepository.findAll()) ) );
			
			return new ResponseEntity<Worker>(worker, HttpStatus.OK);

		}

        return new ResponseEntity<Worker>(HttpStatus.NOT_IMPLEMENTED);
    }

}
