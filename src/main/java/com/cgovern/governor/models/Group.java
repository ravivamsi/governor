/**
 * 
 */
package com.cgovern.governor.models;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author vamsiravi
 *
 */
public class Group {
	
	
	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;
	
	@JsonProperty("roles")
	private List<String> roles = null;

	@JsonProperty("users")
	private List<String> users = null;
	
	
	public Group id(String id) {
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

	public Group name(String name) {
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
	
	
	public Group roles(List<String> roles) {
		this.roles = roles;
		return this;
	}
	
	/**
	 * Get roles
	 * 
	 * @return roles
	 **/
	@ApiModelProperty(value = "")

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
	public Group users(List<String> users) {
		this.users = users;
		return this;
	}
	
	/**
	 * Get users
	 * 
	 * @return users
	 **/
	@ApiModelProperty(value = "")

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}
	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Group group = (Group) o;
		return Objects.equals(this.id, group.id) && Objects.equals(this.name, group.name)
				&& Objects.equals(this.users, group.users) && Objects.equals(this.roles, group.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, users, roles);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Group {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    users: ").append(toIndentedString(users)).append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
