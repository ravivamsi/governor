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
 * Change
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-20T04:35:39.958Z")

public class Change {
	@JsonProperty("sequence")
	private Long sequence = null;

	@JsonProperty("key")
	private String key = null;

	@JsonProperty("oldvalue")
	private String oldvalue = null;

	@JsonProperty("newvalue")
	private String newvalue = null;

	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		CREATE("create"),

		MODIFY("modify"),

		CLONE("clone"),

		DELETE("delete");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(String text) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	/**
	 * Gets or Sets level
	 */
	public enum LevelEnum {
		PLAN("plan"),

		STAGE("stage"),

		JOB("job"),

		TASK("task"),

		VARIABLES("variables");

		private String value;

		LevelEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static LevelEnum fromValue(String text) {
			for (LevelEnum b : LevelEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("level")
	private LevelEnum level = null;

	@JsonProperty("timestamp")
	private String timestamp = null;

	public Change sequence(Long sequence) {
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

	public Change key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Get key
	 * 
	 * @return key
	 **/
	@ApiModelProperty(value = "")

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Change oldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
		return this;
	}

	/**
	 * Get old
	 * 
	 * @return old
	 **/
	@ApiModelProperty(value = "")

	public String getOldValue() {
		return oldvalue;
	}

	public void setOldValue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public Change newvalue(String newvalue) {
		this.newvalue = newvalue;
		return this;
	}

	/**
	 * Get newvalue
	 * 
	 * @return newvalue
	 **/
	@ApiModelProperty(value = "")

	public String getNew() {
		return newvalue;
	}

	public void setNewValue(String newvalue) {
		this.newvalue = newvalue;
	}

	public Change type(TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "")

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Change level(LevelEnum level) {
		this.level = level;
		return this;
	}

	/**
	 * Get level
	 * 
	 * @return level
	 **/
	@ApiModelProperty(value = "")

	public LevelEnum getLevel() {
		return level;
	}

	public void setLevel(LevelEnum level) {
		this.level = level;
	}

	public Change timestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	/**
	 * Get timestamp
	 * 
	 * @return timestamp
	 **/
	@ApiModelProperty(value = "")

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Change change = (Change) o;
		return Objects.equals(this.sequence, change.sequence) && Objects.equals(this.key, change.key)
				&& Objects.equals(this.oldvalue, change.oldvalue) && Objects.equals(this.newvalue, change.newvalue)
				&& Objects.equals(this.type, change.type) && Objects.equals(this.level, change.level)
				&& Objects.equals(this.timestamp, change.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sequence, key, oldvalue, newvalue, type, level, timestamp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Change {\n");

		sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    oldvalue: ").append(toIndentedString(oldvalue)).append("\n");
		sb.append("    newvalue: ").append(toIndentedString(newvalue)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    level: ").append(toIndentedString(level)).append("\n");
		sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
