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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * TaskSchema
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T05:10:13.637Z")

public class TaskSchema   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("fieldkey")
  private String fieldkey = null;

  @JsonProperty("fielddefaultvalue")
  private String fielddefaultvalue = null;

  @JsonProperty("required")
  private Boolean required = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Gets or Sets fieldvaluetype
   */
  public enum FieldvaluetypeEnum {
    STRING("string"),
    
    BOOLEAN("boolean"),
    
    INTEGER("integer"),
    
    FLOAT("float"),
    
    DOUBLE("double"),
    
    PASSWORD("password"),
    
    EMAIL("email"),
    
    URL("url");

    private String value;

    FieldvaluetypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FieldvaluetypeEnum fromValue(String text) {
      for (FieldvaluetypeEnum b : FieldvaluetypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("fieldvaluetype")
  private FieldvaluetypeEnum fieldvaluetype = null;

  @JsonProperty("fieldvalueformat")
  private String fieldvalueformat = null;

  public TaskSchema id(String id) {
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

  public TaskSchema fieldkey(String fieldkey) {
    this.fieldkey = fieldkey;
    return this;
  }

  /**
   * Get fieldkey
   * @return fieldkey
  **/
  @ApiModelProperty(value = "")


  public String getFieldkey() {
    return fieldkey;
  }

  public void setFieldkey(String fieldkey) {
    this.fieldkey = fieldkey;
  }

  public TaskSchema fielddefaultvalue(String fielddefaultvalue) {
    this.fielddefaultvalue = fielddefaultvalue;
    return this;
  }

  /**
   * Get fielddefaultvalue
   * @return fielddefaultvalue
  **/
  @ApiModelProperty(value = "")


  public String getFielddefaultvalue() {
    return fielddefaultvalue;
  }

  public void setFielddefaultvalue(String fielddefaultvalue) {
    this.fielddefaultvalue = fielddefaultvalue;
  }

  public TaskSchema required(Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * Get required
   * @return required
  **/
  @ApiModelProperty(value = "")


  public Boolean isRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public TaskSchema description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskSchema fieldvaluetype(FieldvaluetypeEnum fieldvaluetype) {
    this.fieldvaluetype = fieldvaluetype;
    return this;
  }

  /**
   * Get fieldvaluetype
   * @return fieldvaluetype
  **/
  @ApiModelProperty(value = "")


  public FieldvaluetypeEnum getFieldvaluetype() {
    return fieldvaluetype;
  }

  public void setFieldvaluetype(FieldvaluetypeEnum fieldvaluetype) {
    this.fieldvaluetype = fieldvaluetype;
  }

  public TaskSchema fieldvalueformat(String fieldvalueformat) {
    this.fieldvalueformat = fieldvalueformat;
    return this;
  }

  /**
   * Regex for the format
   * @return fieldvalueformat
  **/
  @ApiModelProperty(value = "Regex for the format")


  public String getFieldvalueformat() {
    return fieldvalueformat;
  }

  public void setFieldvalueformat(String fieldvalueformat) {
    this.fieldvalueformat = fieldvalueformat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskSchema taskSchema = (TaskSchema) o;
    return Objects.equals(this.id, taskSchema.id) &&
        Objects.equals(this.fieldkey, taskSchema.fieldkey) &&
        Objects.equals(this.fielddefaultvalue, taskSchema.fielddefaultvalue) &&
        Objects.equals(this.required, taskSchema.required) &&
        Objects.equals(this.description, taskSchema.description) &&
        Objects.equals(this.fieldvaluetype, taskSchema.fieldvaluetype) &&
        Objects.equals(this.fieldvalueformat, taskSchema.fieldvalueformat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fieldkey, fielddefaultvalue, required, description, fieldvaluetype, fieldvalueformat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskSchema {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fieldkey: ").append(toIndentedString(fieldkey)).append("\n");
    sb.append("    fielddefaultvalue: ").append(toIndentedString(fielddefaultvalue)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    fieldvaluetype: ").append(toIndentedString(fieldvaluetype)).append("\n");
    sb.append("    fieldvalueformat: ").append(toIndentedString(fieldvalueformat)).append("\n");
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

