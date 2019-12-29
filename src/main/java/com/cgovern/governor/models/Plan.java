package com.cgovern.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Plan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Document
public class Plan {
	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("projectid")
	private String projectid = null;

	@JsonProperty("name")
	private String name = null;

	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		BUILD("build"),

		DEPLOY("deploy"),

		TEST("test"),

		MONITOR("monitor"),

		VALIDATE("validate");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	/**
	 * Gets or Sets environment
	 */
	public enum EnvironmentEnum {
		PROD("prod"),

		NONPROD("nonprod");

		private String value;

		EnvironmentEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static EnvironmentEnum fromValue(String text) {
			for (EnvironmentEnum b : EnvironmentEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("environment")
	private EnvironmentEnum environment = null;

	@JsonProperty("shortname")
	private String shortname = null;

	@JsonProperty("stages")
	@Valid
	private List<Index> stages = null;

	@JsonProperty("variables")
	@Valid
	private List<Variable> variables = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Plan id(String id) {
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

	public Plan projectid(String projectid) {
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

	public Plan name(String name) {
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

	public Plan type(TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "")

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Plan environment(EnvironmentEnum environment) {
		this.environment = environment;
		return this;
	}

	/**
	 * Get environment
	 * 
	 * @return environment
	 **/
	@ApiModelProperty(value = "")

	public EnvironmentEnum getEnvironment() {
		return environment;
	}

	public void setEnvironment(EnvironmentEnum environment) {
		this.environment = environment;
	}

	public Plan shortname(String shortname) {
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

	public Plan stages(List<Index> stages) {
		this.stages = stages;
		return this;
	}

	public Plan addStagesItem(Index stagesItem) {
		if (this.stages == null) {
			this.stages = new ArrayList<Index>();
		}
		this.stages.add(stagesItem);
		return this;
	}

	/**
	 * Get stages
	 * 
	 * @return stages
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Index> getStages() {
		return stages;
	}

	public void setStages(List<Index> stages) {
		this.stages = stages;
	}

	public Plan variables(List<Variable> variables) {
		this.variables = variables;
		return this;
	}

	public Plan addVariablesItem(Variable variablesItem) {
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

	public Plan enabled(Boolean enabled) {
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
		Plan plan = (Plan) o;
		return Objects.equals(this.id, plan.id) && Objects.equals(this.projectid, plan.projectid)
				&& Objects.equals(this.name, plan.name) && Objects.equals(this.type, plan.type)
				&& Objects.equals(this.environment, plan.environment) && Objects.equals(this.shortname, plan.shortname)
				&& Objects.equals(this.stages, plan.stages) && Objects.equals(this.variables, plan.variables)
				&& Objects.equals(this.enabled, plan.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projectid, name, type, environment, shortname, stages, variables, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Plan {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    projectid: ").append(toIndentedString(projectid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
		sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
		sb.append("    stages: ").append(toIndentedString(stages)).append("\n");
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
