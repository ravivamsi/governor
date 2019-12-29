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
 * Task
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")
@Document
public class Task {

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("projectid")
	private String projectid = null;

	@JsonProperty("planid")
	private String planid = null;

	@JsonProperty("stageid")
	private String stageid = null;

	@JsonProperty("jobid")
	private String jobid = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("shortname")
	private String shortname = null;

	@JsonProperty("sequence")
	private Long sequence = null;

	@JsonProperty("variables")
	@Valid
	private List<Variable> variables = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Task id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Task projectid(String projectid) {
		this.projectid = projectid;
		return this;
	}

	/**
	 * Get projectid
	 * 
	 * @return projectid
	 **/
	@ApiModelProperty(value = "")

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public Task planid(String planid) {
		this.planid = planid;
		return this;
	}

	/**
	 * Get planid
	 * 
	 * @return planid
	 **/
	@ApiModelProperty(value = "")

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public Task stageid(String stageid) {
		this.stageid = stageid;
		return this;
	}

	/**
	 * Get stageid
	 * 
	 * @return stageid
	 **/
	@ApiModelProperty(value = "")

	public String getStageid() {
		return stageid;
	}

	public void setStageid(String stageid) {
		this.stageid = stageid;
	}

	public Task jobid(String jobid) {
		this.jobid = jobid;
		return this;
	}

	/**
	 * Get jobid
	 * 
	 * @return jobid
	 **/
	@ApiModelProperty(value = "")

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Task name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task shortname(String shortname) {
		this.shortname = shortname;
		return this;
	}

	/**
	 * Get shortname
	 * 
	 * @return shortname
	 **/
	@ApiModelProperty(value = "")

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Task sequence(Long sequence) {
		this.sequence = sequence;
		return this;
	}

	/**
	 * Get sequence
	 * 
	 * @return sequence
	 **/
	@ApiModelProperty(value = "")

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Task variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public Task addVariablesItem(Variable variablesItem) {
		if (this.variables == null) {
			this.variables = new ArrayList<Variable>();
		}
		this.variables.add(variablesItem);
		return this;
	}

	/**
	 * Get variables
	 * 
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

	public Task enabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	/**
	 * Get enabled
	 * 
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
		Task task = (Task) o;
		return Objects.equals(this.id, task.id) && Objects.equals(this.projectid, task.projectid)
				&& Objects.equals(this.planid, task.planid) && Objects.equals(this.stageid, task.stageid)
				&& Objects.equals(this.jobid, task.jobid) && Objects.equals(this.name, task.name)
				&& Objects.equals(this.shortname, task.shortname) && Objects.equals(this.sequence, task.sequence)
				&& Objects.equals(this.variables, task.variables) && Objects.equals(this.enabled, task.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projectid, planid, stageid, jobid, name, shortname, sequence, variables, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Task {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    projectid: ").append(toIndentedString(projectid)).append("\n");
		sb.append("    planid: ").append(toIndentedString(planid)).append("\n");
		sb.append("    stageid: ").append(toIndentedString(stageid)).append("\n");
		sb.append("    jobid: ").append(toIndentedString(jobid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
		sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
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
