/**
 * 
 */
package com.cgovern.governor.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vamsiravi
 *
 */


import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * Audit
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-20T04:35:39.958Z")



public class Audit {
	  @JsonProperty("id")
	  private String id = null;

	  @JsonProperty("planId")
	  private String planId = null;

	  @JsonProperty("change")
	  @Valid
	  private List<Change> change = null;

	  public Audit id(String id) {
	    this.id = id;
	    return this;
	  }

	  /**
	   * Get id
	   * @return id
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull


	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public Audit planId(String planId) {
	    this.planId = planId;
	    return this;
	  }

	  /**
	   * Get planId
	   * @return planId
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull


	  public String getPlanId() {
	    return planId;
	  }

	  public void setPlanId(String planId) {
	    this.planId = planId;
	  }

	  public Audit change(List<Change> change) {
	    this.change = change;
	    return this;
	  }

	  public Audit addChangeItem(Change changeItem) {
	    if (this.change == null) {
	      this.change = new ArrayList<Change>();
	    }
	    this.change.add(changeItem);
	    return this;
	  }

	  /**
	   * Get change
	   * @return change
	  **/
	  @ApiModelProperty(value = "")

	  @Valid

	  public List<Change> getChange() {
	    return change;
	  }

	  public void setChange(List<Change> change) {
	    this.change = change;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Audit audit = (Audit) o;
	    return Objects.equals(this.id, audit.id) &&
	        Objects.equals(this.planId, audit.planId) &&
	        Objects.equals(this.change, audit.change);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, planId, change);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Audit {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
	    sb.append("    change: ").append(toIndentedString(change)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
