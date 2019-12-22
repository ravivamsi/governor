package com.servec.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Status
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T05:19:56.685Z")

public class Status {
	@JsonProperty("id")
	private ObjectId id = null;

	/**
	 * Gets or Sets overallstatus
	 */
	public enum OverallstatusEnum {
		UP("up"),

		DOWN("down"),

		UNKNOWN("unknown");

		private String value;

		OverallstatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static OverallstatusEnum fromValue(String text) {
			for (OverallstatusEnum b : OverallstatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("overallstatus")
	private OverallstatusEnum overallstatus = null;

	@JsonProperty("dependencies")
	@Valid
	private List<Dependency> dependencies = null;

	public Status id(ObjectId id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Status overallstatus(OverallstatusEnum overallstatus) {
		this.overallstatus = overallstatus;
		return this;
	}

	/**
	 * Get overallstatus
	 * 
	 * @return overallstatus
	 **/
	@ApiModelProperty(value = "")

	public OverallstatusEnum getOverallstatus() {
		return overallstatus;
	}

	public void setOverallstatus(OverallstatusEnum overallstatus) {
		this.overallstatus = overallstatus;
	}

	public Status dependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
		return this;
	}

	public Status addDependenciesItem(Dependency dependenciesItem) {
		if (this.dependencies == null) {
			this.dependencies = new ArrayList<Dependency>();
		}
		this.dependencies.add(dependenciesItem);
		return this;
	}

	/**
	 * Get dependencies
	 * 
	 * @return dependencies
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Status status = (Status) o;
		return Objects.equals(this.id, status.id) && Objects.equals(this.overallstatus, status.overallstatus)
				&& Objects.equals(this.dependencies, status.dependencies);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, overallstatus, dependencies);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Status {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    overallstatus: ").append(toIndentedString(overallstatus)).append("\n");
		sb.append("    dependencies: ").append(toIndentedString(dependencies)).append("\n");
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
