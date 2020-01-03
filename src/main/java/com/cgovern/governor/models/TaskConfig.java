/**
 * 
 */
package com.cgovern.governor.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vamsiravi
 *
 */

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TaskConfig
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T04:54:06.978Z")

public class TaskConfig {
	
	  @JsonProperty("id")
	  private String id = null;

	  @JsonProperty("name")
	  private String name = null;

	  @JsonProperty("dimageid")
	  private String dimageid = null;

	  @JsonProperty("schema")
	  @Valid
	  private List<TaskSchema> schema = null;

	  public TaskConfig id(String id) {
	    this.id = id;
	    return this;
	  }

	  /**
	   * Get id
	   * @return id
	  **/
	  @ApiModelProperty(value = "")


	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public TaskConfig name(String name) {
	    this.name = name;
	    return this;
	  }

	  /**
	   * Get name
	   * @return name
	  **/
	  @ApiModelProperty(value = "")


	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public TaskConfig dimageid(String dimageid) {
	    this.dimageid = dimageid;
	    return this;
	  }

	  /**
	   * Get dimageid
	   * @return dimageid
	  **/
	  @ApiModelProperty(value = "")


	  public String getDimageid() {
	    return dimageid;
	  }

	  public void setDimageid(String dimageid) {
	    this.dimageid = dimageid;
	  }

	  public TaskConfig schema(List<TaskSchema> schema) {
	    this.schema = schema;
	    return this;
	  }

	  public TaskConfig addSchemaItem(TaskSchema schemaItem) {
	    if (this.schema == null) {
	      this.schema = new ArrayList<TaskSchema>();
	    }
	    this.schema.add(schemaItem);
	    return this;
	  }

	  /**
	   * Get schema
	   * @return schema
	  **/
	  @ApiModelProperty(value = "")

	  @Valid

	  public List<TaskSchema> getSchema() {
	    return schema;
	  }

	  public void setSchema(List<TaskSchema> schema) {
	    this.schema = schema;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    TaskConfig taskConfig = (TaskConfig) o;
	    return Objects.equals(this.id, taskConfig.id) &&
	        Objects.equals(this.name, taskConfig.name) &&
	        Objects.equals(this.dimageid, taskConfig.dimageid) &&
	        Objects.equals(this.schema, taskConfig.schema);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id, name, dimageid, schema);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class TaskConfig {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    name: ").append(toIndentedString(name)).append("\n");
	    sb.append("    dimageid: ").append(toIndentedString(dimageid)).append("\n");
	    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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
	  }}
