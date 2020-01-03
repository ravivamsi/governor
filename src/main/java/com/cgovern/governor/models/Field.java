/**
 * 
 */
package com.cgovern.governor.models;

/**
 * @author vamsiravi
 *
 */

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Field
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T04:54:06.978Z")

public class Field {

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("value")
	private String value = null;

	public Field key(String key) {
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

	public Field value(String value) {
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
		Field field = (Field) o;
		return Objects.equals(this.key, field.key) && Objects.equals(this.value, field.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Field {\n");

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
