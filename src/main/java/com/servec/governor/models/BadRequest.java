package com.servec.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BadRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class BadRequest {
	@JsonProperty("id")
	private UUID id = null;

	@JsonProperty("code")
	private Integer code = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("fields")
	@Valid
	private List<String> fields = null;

	public BadRequest id(UUID id) {
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

	public BadRequest code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "")

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public BadRequest message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "")

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BadRequest fields(List<String> fields) {
		this.fields = fields;
		return this;
	}

	public BadRequest addFieldsItem(String fieldsItem) {
		if (this.fields == null) {
			this.fields = new ArrayList<String>();
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

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
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
		BadRequest badRequest = (BadRequest) o;
		return Objects.equals(this.id, badRequest.id) && Objects.equals(this.code, badRequest.code)
				&& Objects.equals(this.message, badRequest.message) && Objects.equals(this.fields, badRequest.fields);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, message, fields);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BadRequest {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
