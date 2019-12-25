package com.cgovern.governor.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DImage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-22T04:22:26.530Z")

@Document
public class DImage {

	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("shortname")
	private String shortname = null;

	@JsonProperty("imagename")
	private String imagename = null;

	@JsonProperty("imageversion")
	private String imageversion = null;

	@JsonProperty("imageid")
	private String imageid = null;

	@JsonProperty("imagetag")
	private String imagetag = null;

	public DImage id(String id) {
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

	public DImage shortname(String shortname) {
		this.shortname = shortname;
		return this;
	}

	/**
	 * Get shortname
	 * 
	 * @return shortname
	 **/
	@ApiModelProperty(value = "")

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public DImage imagename(String imagename) {
		this.imagename = imagename;
		return this;
	}

	/**
	 * Get imagename
	 * 
	 * @return imagename
	 **/
	@ApiModelProperty(value = "")

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public DImage imageversion(String imageversion) {
		this.imageversion = imageversion;
		return this;
	}

	/**
	 * Get imageversion
	 * 
	 * @return imageversion
	 **/
	@ApiModelProperty(value = "")

	public String getImageversion() {
		return imageversion;
	}

	public void setImageversion(String imageversion) {
		this.imageversion = imageversion;
	}

	public DImage imageid(String imageid) {
		this.imageid = imageid;
		return this;
	}

	/**
	 * Get imageid
	 * 
	 * @return imageid
	 **/
	@ApiModelProperty(value = "")

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public DImage imagetag(String imagetag) {
		this.imagetag = imagetag;
		return this;
	}

	/**
	 * Get imagetag
	 * 
	 * @return imagetag
	 **/
	@ApiModelProperty(value = "")

	public String getImagetag() {
		return imagetag;
	}

	public void setImagetag(String imagetag) {
		this.imagetag = imagetag;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DImage dimage = (DImage) o;
		return Objects.equals(this.id, dimage.id) && Objects.equals(this.shortname, dimage.shortname)
				&& Objects.equals(this.imagename, dimage.imagename)
				&& Objects.equals(this.imageversion, dimage.imageversion)
				&& Objects.equals(this.imageid, dimage.imageid) && Objects.equals(this.imagetag, dimage.imagetag);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, shortname, imagename, imageversion, imageid, imagetag);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DImage {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
		sb.append("    imagename: ").append(toIndentedString(imagename)).append("\n");
		sb.append("    imageversion: ").append(toIndentedString(imageversion)).append("\n");
		sb.append("    imageid: ").append(toIndentedString(imageid)).append("\n");
		sb.append("    imagetag: ").append(toIndentedString(imagetag)).append("\n");
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
