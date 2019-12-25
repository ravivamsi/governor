package com.servec.governor.models;

import java.util.Objects;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Variable
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class Variable {
	@JsonProperty("id")
	private UUID id = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("value")
	private String value = null;

	public Variable id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Variable key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Get key
	 * 
	 * @return key
	 **/
	@ApiModelProperty(value = "")

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Variable value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * 
	 * @return value
	 **/
	@ApiModelProperty(value = "")

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Variable variable = (Variable) o;
		return Objects.equals(this.id, variable.id) && Objects.equals(this.key, variable.key)
				&& Objects.equals(this.value, variable.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, key, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Variable {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
