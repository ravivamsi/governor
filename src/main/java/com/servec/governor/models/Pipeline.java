package com.servec.governor.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Pipeline
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

public class Pipeline {
	@JsonProperty("id")
	private UUID id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("components")
	@Valid
	private List<Component> components = null;

	@JsonProperty("enabled")
	private Boolean enabled = null;

	public Pipeline id(UUID id) {
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Pipeline name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pipeline components(List<Component> components) {
		this.components = components;
		return this;
	}

	public Pipeline addComponentsItem(Component componentsItem) {
		if (this.components == null) {
			this.components = new ArrayList<Component>();
		}
		this.components.add(componentsItem);
		return this;
	}

	/**
	 * Get components
	 * 
	 * @return components
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public Pipeline enabled(Boolean enabled) {
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
		Pipeline pipeline = (Pipeline) o;
		return Objects.equals(this.id, pipeline.id) && Objects.equals(this.name, pipeline.name)
				&& Objects.equals(this.components, pipeline.components)
				&& Objects.equals(this.enabled, pipeline.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, components, enabled);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Pipeline {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    components: ").append(toIndentedString(components)).append("\n");
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
