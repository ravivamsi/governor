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
 * Token
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-03T04:54:06.978Z")

public class Token {
	@JsonProperty("token")
	private String token = null;

	@JsonProperty("expiresin")
	private Integer expiresin = null;

	@JsonProperty("username")
	private String username = null;

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

	public Token token(String token) {
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

	public Token expiresin(Integer expiresin) {
		this.expiresin = expiresin;
		return this;
	}

	/**
	 * Get expiresin
	 * 
	 * @return expiresin
	 **/
	@ApiModelProperty(value = "")

	public Integer getExpiresin() {
		return expiresin;
	}

	public void setExpiresin(Integer expiresin) {
		this.expiresin = expiresin;
	}

	public Token username(String username) {
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

	public Token status(StatusEnum status) {
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
		Token token = (Token) o;
		return Objects.equals(this.token, token.token) && Objects.equals(this.expiresin, token.expiresin)
				&& Objects.equals(this.username, token.username) && Objects.equals(this.status, token.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(token, expiresin, username, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Token {\n");

		sb.append("    token: ").append(toIndentedString(token)).append("\n");
		sb.append("    expiresin: ").append(toIndentedString(expiresin)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
