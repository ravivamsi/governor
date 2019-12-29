package com.cgovern.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Job
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Document
public class Job {

	@Id
	@JsonProperty("id")
	  private String id = null;

	  @JsonProperty("projectid")
	  private String projectid = null;

	  @JsonProperty("planid")
	  private String planid = null;

	  @JsonProperty("stageid")
	  private String stageid = null;

	  @JsonProperty("name")
	  private String name = null;

	  @JsonProperty("shortname")
	  private String shortname = null;

	  @JsonProperty("tasks")
	  @Valid
	  private List<Index> tasks = null;

	  @JsonProperty("variables")
	  @Valid
	  private List<Variable> variables = null;

	  @JsonProperty("enabled")
	  private Boolean enabled = null;

	  public Job id(String id) {
	    this.id = id;
	    return this;
	  }

	  /**
	   * Get id
	   * @return id
	  **/
	  @ApiModelProperty(value = "")


	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public Job projectid(String projectid) {
	    this.projectid = projectid;
	    return this;
	  }

	  /**
	   * Get projectid
	   * @return projectid
	  **/
	  @ApiModelProperty(value = "")


	  public String getProjectid() {
	    return projectid;
	  }

	  public void setProjectid(String projectid) {
	    this.projectid = projectid;
	  }

	  public Job planid(String planid) {
	    this.planid = planid;
	    return this;
	  }

	  /**
	   * Get planid
	   * @return planid
	  **/
	  @ApiModelProperty(value = "")


	  public String getPlanid() {
	    return planid;
	  }

	  public void setPlanid(String planid) {
	    this.planid = planid;
	  }

	  public Job stageid(String stageid) {
	    this.stageid = stageid;
	    return this;
	  }

	  /**
	   * Get stageid
	   * @return stageid
	  **/
	  @ApiModelProperty(value = "")


	  public String getStageid() {
	    return stageid;
	  }

	  public void setStageid(String stageid) {
	    this.stageid = stageid;
	  }

	  public Job name(String name) {
	    this.name = name;
	    return this;
	  }

	  /**
	   * Get name
	   * @return name
	  **/
	  @ApiModelProperty(value = "")


	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Job shortname(String shortname) {
	    this.shortname = shortname;
	    return this;
	  }

	  /**
	   * Get shortname
	   * @return shortname
	  **/
	  @ApiModelProperty(value = "")


	  public String getShortname() {
	    return shortname;
	  }

	  public void setShortname(String shortname) {
	    this.shortname = shortname;
	  }

	  public Job tasks(List<Index> tasks) {
	    this.tasks = tasks;
	    return this;
	  }

	  public Job addTasksItem(Index tasksItem) {
	    if (this.tasks == null) {
	      this.tasks = new ArrayList<Index>();
	    }
	    this.tasks.add(tasksItem);
	    return this;
	  }

	  /**
	   * Get tasks
	   * @return tasks
	  **/
	  @ApiModelProperty(value = "")

	  @Valid

	  public List<Index> getTasks() {
	    return tasks;
	  }

	  public void setTasks(List<Index> tasks) {
	    this.tasks = tasks;
	  }

	  public Job variables(List<Variable> variables) {
	    this.variables = variables;
	    return this;
	  }

	  public Job addVariablesItem(Variable variablesItem) {
	    if (this.variables == null) {
	      this.variables = new ArrayList<Variable>();
	    }
	    this.variables.add(variablesItem);
	    return this;
	  }

	  /**
	   * Get variables
	   * @return variables
	  **/
	  @ApiModelProperty(value = "")

	  @Valid

	  public List<Variable> getVariables() {
	    return variables;
	  }

	  public void setVariables(List<Variable> variables) {
	    this.variables = variables;
	  }

	  public Job enabled(Boolean enabled) {
	    this.enabled = enabled;
	    return this;
	  }

	  /**
	   * Get enabled
	   * @return enabled
	  **/
	  @ApiModelProperty(value = "")


	  public Boolean isEnabled() {
	    return enabled;
	  }

	  public void setEnabled(Boolean enabled) {
	    this.enabled = enabled;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Job job = (Job) o;
	    return Objects.equals(this.id, job.id) &&
	        Objects.equals(this.projectid, job.projectid) &&
	        Objects.equals(this.planid, job.planid) &&
	        Objects.equals(this.stageid, job.stageid) &&
	        Objects.equals(this.name, job.name) &&
	        Objects.equals(this.shortname, job.shortname) &&
	        Objects.equals(this.tasks, job.tasks) &&
	        Objects.equals(this.variables, job.variables) &&
	        Objects.equals(this.enabled, job.enabled);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, projectid, planid, stageid, name, shortname, tasks, variables, enabled);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Job {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    projectid: ").append(toIndentedString(projectid)).append("\n");
	    sb.append("    planid: ").append(toIndentedString(planid)).append("\n");
	    sb.append("    stageid: ").append(toIndentedString(stageid)).append("\n");
	    sb.append("    name: ").append(toIndentedString(name)).append("\n");
	    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
	    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
	    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
	    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
