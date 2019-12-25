/**
 * 
 */
package com.servec.governor.models;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Index
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-24T22:37:55.063Z")

public class Index {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("sequence")
	private Long sequence = null;

	public Index id(String id) {
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

	public Index sequence(Long sequence) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Index index = (Index) o;
		return Objects.equals(this.id, index.id) && Objects.equals(this.sequence, index.sequence);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sequence);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Index {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
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