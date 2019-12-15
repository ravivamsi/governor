package com.servec.governor.models;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Health
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-15T06:26:02.812Z")

public class Health   {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("appname")
  private String appname = null;

  @JsonProperty("buildtime")
  private String buildtime = null;

  @JsonProperty("releasetime")
  private String releasetime = null;

  public Health version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Health appname(String appname) {
    this.appname = appname;
    return this;
  }

  /**
   * Get appname
   * @return appname
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public Health buildtime(String buildtime) {
    this.buildtime = buildtime;
    return this;
  }

  /**
   * Get buildtime
   * @return buildtime
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getBuildtime() {
    return buildtime;
  }

  public void setBuildtime(String buildtime) {
    this.buildtime = buildtime;
  }

  public Health releasetime(String releasetime) {
    this.releasetime = releasetime;
    return this;
  }

  /**
   * Get releasetime
   * @return releasetime
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getReleasetime() {
    return releasetime;
  }

  public void setReleasetime(String releasetime) {
    this.releasetime = releasetime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Health health = (Health) o;
    return Objects.equals(this.version, health.version) &&
        Objects.equals(this.appname, health.appname) &&
        Objects.equals(this.buildtime, health.buildtime) &&
        Objects.equals(this.releasetime, health.releasetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, appname, buildtime, releasetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Health {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    appname: ").append(toIndentedString(appname)).append("\n");
    sb.append("    buildtime: ").append(toIndentedString(buildtime)).append("\n");
    sb.append("    releasetime: ").append(toIndentedString(releasetime)).append("\n");
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

