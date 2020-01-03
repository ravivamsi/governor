/**
 * 
 */
package com.cgovern.governor.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Session
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T07:16:00.785Z")

@Document
public class Session {

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("token")
	private String token = null;

	@JsonProperty("expires")
	private Integer expires = null;

	@JsonProperty("starttime")
	private String starttime = null;

	@JsonProperty("endtime")
	private String endtime = null;

	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		ACTIVE("active"),

		PENDING("pending"),

		SUSPENDED("suspended");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	public Session id(String id) {
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

	public Session username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 **/
	@ApiModelProperty(value = "")

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Session token(String token) {
		this.token = token;
		return this;
	}

	/**
	 * Get token
	 * 
	 * @return token
	 **/
	@ApiModelProperty(value = "")

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Session expires(Integer expires) {
		this.expires = expires;
		return this;
	}

	/**
	 * Get expires
	 * 
	 * @return expires
	 **/
	@ApiModelProperty(value = "")

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public Session starttime(String starttime) {
		this.starttime = starttime;
		return this;
	}

	/**
	 * Get starttime
	 * 
	 * @return starttime
	 **/
	@ApiModelProperty(value = "")

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Session endtime(String endtime) {
		this.endtime = endtime;
		return this;
	}

	/**
	 * Get endtime
	 * 
	 * @return endtime
	 **/
	@ApiModelProperty(value = "")

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Session status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Session session = (Session) o;
		return Objects.equals(this.id, session.id) && Objects.equals(this.username, session.username)
				&& Objects.equals(this.token, session.token) && Objects.equals(this.expires, session.expires)
				&& Objects.equals(this.starttime, session.starttime) && Objects.equals(this.endtime, session.endtime)
				&& Objects.equals(this.status, session.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, token, expires, starttime, endtime, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Session {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    token: ").append(toIndentedString(token)).append("\n");
		sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
		sb.append("    starttime: ").append(toIndentedString(starttime)).append("\n");
		sb.append("    endtime: ").append(toIndentedString(endtime)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
