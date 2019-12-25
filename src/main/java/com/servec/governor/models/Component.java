package com.servec.governor.models;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Component
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class Component {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		PLAN("plan"),

		TRIGGER("trigger"),

		NOTIFICATION("notification");

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

	@JsonProperty("sequence")
	private Long sequence = null;

	public Component id(String id) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Component type(TypeEnum type) {
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

	public Component sequence(Long sequence) {
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
		Component component = (Component) o;
		return Objects.equals(this.id, component.id) && Objects.equals(this.type, component.type)
				&& Objects.equals(this.sequence, component.sequence);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, sequence);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Component {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
