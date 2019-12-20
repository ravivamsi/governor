package com.servec.governor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servec.governor.api.StatusApi;
import com.servec.governor.models.Status;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T05:19:56.685Z")

@Controller
public class StatusApiController implements StatusApi {

    private static final Logger log = LoggerFactory.getLogger(StatusApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StatusApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Status> statusGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Status>(objectMapper.readValue("{  \"overallstatus\" : \"up\",  \"id\" : 0,  \"dependencies\" : [ {    \"name\" : \"name\",    \"id\" : 6,    \"status\" : \"up\"  }, {    \"name\" : \"name\",    \"id\" : 6,    \"status\" : \"up\"  } ]}", Status.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Status>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Status>(HttpStatus.NOT_IMPLEMENTED);
    }

}
