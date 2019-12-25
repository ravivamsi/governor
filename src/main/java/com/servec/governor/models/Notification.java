package com.servec.governor.models;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Notification
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class Notification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("to")
	private String to = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Notification id(String id) {
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

	public Notification name(String name) {
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

	public Notification to(String to) {
		this.to = to;
		return this;
	}

	/**
	 * Get to
	 * 
	 * @return to
	 **/
	@ApiModelProperty(value = "")

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Notification type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Notification enabled(Boolean enabled) {
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
		Notification notification = (Notification) o;
		return Objects.equals(this.id, notification.id) && Objects.equals(this.name, notification.name)
				&& Objects.equals(this.to, notification.to) && Objects.equals(this.type, notification.type)
				&& Objects.equals(this.enabled, notification.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, to, type, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Notification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    to: ").append(toIndentedString(to)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
