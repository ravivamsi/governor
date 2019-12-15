package com.servec.governor.models;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Heartbeat
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T06:26:02.812Z")

public class Heartbeat   {
  @JsonProperty("pulse")
  private String pulse = null;

  public Heartbeat pulse(String pulse) {
    this.pulse = pulse;
    return this;
  }

  /**
   * Get pulse
   * @return pulse
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPulse() {
    return pulse;
  }

  public void setPulse(String pulse) {
    this.pulse = pulse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Heartbeat heartbeat = (Heartbeat) o;
    return Objects.equals(this.pulse, heartbeat.pulse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pulse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Heartbeat {\n");
    
    sb.append("    pulse: ").append(toIndentedString(pulse)).append("\n");
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

