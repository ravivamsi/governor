package com.servec.governor.models;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Trigger
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class Trigger {
	@JsonProperty("id")
	private ObjectId id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Trigger id(ObjectId id) {
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

	public Trigger name(String name) {
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

	public Trigger enabled(Boolean enabled) {
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
		Trigger trigger = (Trigger) o;
		return Objects.equals(this.id, trigger.id) && Objects.equals(this.name, trigger.name)
				&& Objects.equals(this.enabled, trigger.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Trigger {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
