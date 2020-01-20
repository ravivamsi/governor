/**
 * 
 */
package com.cgovern.governor.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cgovern.governor.models.Audit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-20T04:35:39.958Z")

@Api(value = "audit", description = "the audit API")

public interface AuditApi {




    @ApiOperation(value = "Add a new pet to the store", nickname = "retrieveAudit", notes = "", response = Audit.class, tags={ "audit", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Invalid input", response = Audit.class),
        @ApiResponse(code = 400, message = "Audit Not Found") })
    @RequestMapping(value = "/audit/{auditId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Audit> retrieveAudit(@ApiParam(value = "AuditId object that needs to retrieved",required=true) @PathVariable("auditId") String auditId) ;


    @ApiOperation(value = "Update an existing Audit Log", nickname = "updateAudit", notes = "", tags={ "audit", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Accepted"),
        @ApiResponse(code = 404, message = "Audit not found") })
    @RequestMapping(value = "/audit/{auditId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
     ResponseEntity<Void> updateAudit(@ApiParam(value = "AuditId object that needs to retrieved",required=true) @PathVariable("auditId") String auditId,@ApiParam(value = "Pet object that needs to be added to the store" ,required=true )  @Valid @RequestBody Audit body) ;
}
