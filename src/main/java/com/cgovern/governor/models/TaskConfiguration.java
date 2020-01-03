/**
 * 
 */
package com.cgovern.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TaskConfiguration
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T05:23:34.170Z")

public class TaskConfiguration {
	@JsonProperty("taskconfigid")
	private String taskconfigid = null;

	@JsonProperty("fields")
	@Valid
	private List<Field> fields = null;

	public TaskConfiguration taskconfigid(String taskconfigid) {
		this.taskconfigid = taskconfigid;
		return this;
	}

	/**
	 * Get taskconfigid
	 * 
	 * @return taskconfigid
	 **/
	@ApiModelProperty(value = "")

	public String getTaskconfigid() {
		return taskconfigid;
	}

	public void setTaskconfigid(String taskconfigid) {
		this.taskconfigid = taskconfigid;
	}

	public TaskConfiguration fields(List<Field> fields) {
		this.fields = fields;
		return this;
	}

	public TaskConfiguration addFieldsItem(Field fieldsItem) {
		if (this.fields == null) {
			this.fields = new ArrayList<Field>();
		}
		this.fields.add(fieldsItem);
		return this;
	}

	/**
	 * Get fields
	 * 
	 * @return fields
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TaskConfiguration taskConfiguration = (TaskConfiguration) o;
		return Objects.equals(this.taskconfigid, taskConfiguration.taskconfigid)
				&& Objects.equals(this.fields, taskConfiguration.fields);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskconfigid, fields);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TaskConfiguration {\n");

		sb.append("    taskconfigid: ").append(toIndentedString(taskconfigid)).append("\n");
		sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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
