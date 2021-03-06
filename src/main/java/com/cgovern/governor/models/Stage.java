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
 * Stage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Document
public class Stage {

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("projectid")
	private String projectid = null;

	@JsonProperty("planid")
	private String planid = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("shortname")
	private String shortname = null;

	@JsonProperty("sequence")
	private Long sequence = null;

	@JsonProperty("jobs")
	@Valid
	private List<Index> jobs = null;

	@JsonProperty("variables")
	@Valid
	private List<Variable> variables = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Stage id(String id) {
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

	public Stage projectid(String projectid) {
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

	public Stage planid(String planid) {
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

	public Stage name(String name) {
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

	public Stage shortname(String shortname) {
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

	public Stage sequence(Long sequence) {
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

	public Stage stages(List<Index> jobs) {
		this.jobs = jobs;
		return this;
	}

	public Stage addStagesItem(Index jobsItem) {
		if (this.jobs == null) {
			this.jobs = new ArrayList<Index>();
		}
		this.jobs.add(jobsItem);
		return this;
	}

	/**
	 * Get stages
	 * 
	 * @return stages
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Index> getJobs() {
		return jobs;
	}

	public void setJobs(List<Index> jobs) {
		this.jobs = jobs;
	}

	public Stage variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public Stage addVariablesItem(Variable variablesItem) {
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

	public Stage enabled(Boolean enabled) {
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
		Stage stage = (Stage) o;
		return Objects.equals(this.id, stage.id) && Objects.equals(this.projectid, stage.projectid)
				&& Objects.equals(this.planid, stage.planid) && Objects.equals(this.name, stage.name)
				&& Objects.equals(this.shortname, stage.shortname) && Objects.equals(this.sequence, stage.sequence)
				&& Objects.equals(this.jobs, stage.jobs) && Objects.equals(this.variables, stage.variables)
				&& Objects.equals(this.enabled, stage.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projectid, planid, name, shortname, sequence, jobs, variables, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Stage {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    projectid: ").append(toIndentedString(projectid)).append("\n");
		sb.append("    planid: ").append(toIndentedString(planid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
		sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
		sb.append("    jobs: ").append(toIndentedString(jobs)).append("\n");
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
