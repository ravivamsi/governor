package com.servec.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Project
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Document
public class Project {

	@Id
	@JsonProperty("id")
	private ObjectId id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("shortname")
	private String shortname = null;

	@JsonProperty("plans")
	@Valid
	private List<Index> plans = null;

	@JsonProperty("variables")
	@Valid
	private List<Variable> variables = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Project id(ObjectId id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Project name(String name) {
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

	public Project shortname(String shortname) {
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

	public Project plans(List<Index> plans) {
		this.plans = plans;
		return this;
	}

	public Project addPlansItem(Index plansItem) {
		if (this.plans == null) {
			this.plans = new ArrayList<Index>();
		}
		this.plans.add(plansItem);
		return this;
	}

	/**
	 * Get plans
	 * 
	 * @return plans
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Index> getPlans() {
		return plans;
	}

	public void setPlans(List<Index> plans) {
		this.plans = plans;
	}

	public Project variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public Project addVariablesItem(Variable variablesItem) {
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

	public Project enabled(Boolean enabled) {
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
		Project project = (Project) o;
		return Objects.equals(this.id, project.id) && Objects.equals(this.name, project.name)
				&& Objects.equals(this.shortname, project.shortname) && Objects.equals(this.plans, project.plans)
				&& Objects.equals(this.variables, project.variables) && Objects.equals(this.enabled, project.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, shortname, plans, variables, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Project {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
		sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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
