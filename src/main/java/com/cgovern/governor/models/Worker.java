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
 * Worker
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-25T23:34:55.664Z")

@Document
public class Worker {

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("sequence")
	private Long sequence = null;

	@JsonProperty("ipaddr")
	private String ipaddr = null;

	@JsonProperty("hostname")
	private String hostname = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("password")
	private String password = null;

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

	public Worker id(String id) {
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

	public Worker sequence(Long sequence) {
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

	public Worker ipaddr(String ipaddr) {
		this.ipaddr = ipaddr;
		return this;
	}

	/**
	 * Get ipaddr
	 * 
	 * @return ipaddr
	 **/
	@ApiModelProperty(value = "")

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public Worker hostname(String hostname) {
		this.hostname = hostname;
		return this;
	}

	/**
	 * Get hostname
	 * 
	 * @return hostname
	 **/
	@ApiModelProperty(value = "")

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Worker username(String username) {
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

	public Worker password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "")

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Worker status(StatusEnum status) {
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
		Worker worker = (Worker) o;
		return Objects.equals(this.id, worker.id) && Objects.equals(this.sequence, worker.sequence)
				&& Objects.equals(this.ipaddr, worker.ipaddr) && Objects.equals(this.hostname, worker.hostname)
				&& Objects.equals(this.username, worker.username) && Objects.equals(this.password, worker.password)
				&& Objects.equals(this.status, worker.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sequence, ipaddr, hostname, username, password, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Worker {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
		sb.append("    ipaddr: ").append(toIndentedString(ipaddr)).append("\n");
		sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
