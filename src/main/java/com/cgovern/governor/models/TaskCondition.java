/**
 * 
 */
package com.cgovern.governor.models;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * TaskCondition
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T05:12:21.870Z")

public class TaskCondition   {
  @JsonProperty("enabled")
  private Boolean enabled = null;

  @JsonProperty("conditionkey")
  private String conditionkey = null;

  @JsonProperty("conditionvalue")
  private String conditionvalue = null;

  /**
   * Gets or Sets conditiontype
   */
  public enum ConditiontypeEnum {
    MATCHES("matches"),
    
    EQUALS("equals"),
    
    EXISTS("exists");

    private String value;

    ConditiontypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ConditiontypeEnum fromValue(String text) {
      for (ConditiontypeEnum b : ConditiontypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("conditiontype")
  private ConditiontypeEnum conditiontype = null;

  public TaskCondition enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(value = "")


  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public TaskCondition conditionkey(String conditionkey) {
    this.conditionkey = conditionkey;
    return this;
  }

  /**
   * Get conditionkey
   * @return conditionkey
  **/
  @ApiModelProperty(value = "")


  public String getConditionkey() {
    return conditionkey;
  }

  public void setConditionkey(String conditionkey) {
    this.conditionkey = conditionkey;
  }

  public TaskCondition conditionvalue(String conditionvalue) {
    this.conditionvalue = conditionvalue;
    return this;
  }

  /**
   * Get conditionvalue
   * @return conditionvalue
  **/
  @ApiModelProperty(value = "")


  public String getConditionvalue() {
    return conditionvalue;
  }

  public void setConditionvalue(String conditionvalue) {
    this.conditionvalue = conditionvalue;
  }

  public TaskCondition conditiontype(ConditiontypeEnum conditiontype) {
    this.conditiontype = conditiontype;
    return this;
  }

  /**
   * Get conditiontype
   * @return conditiontype
  **/
  @ApiModelProperty(value = "")


  public ConditiontypeEnum getConditiontype() {
    return conditiontype;
  }

  public void setConditiontype(ConditiontypeEnum conditiontype) {
    this.conditiontype = conditiontype;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskCondition taskCondition = (TaskCondition) o;
    return Objects.equals(this.enabled, taskCondition.enabled) &&
        Objects.equals(this.conditionkey, taskCondition.conditionkey) &&
        Objects.equals(this.conditionvalue, taskCondition.conditionvalue) &&
        Objects.equals(this.conditiontype, taskCondition.conditiontype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, conditionkey, conditionvalue, conditiontype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskCondition {\n");
    
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    conditionkey: ").append(toIndentedString(conditionkey)).append("\n");
    sb.append("    conditionvalue: ").append(toIndentedString(conditionvalue)).append("\n");
    sb.append("    conditiontype: ").append(toIndentedString(conditiontype)).append("\n");
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

