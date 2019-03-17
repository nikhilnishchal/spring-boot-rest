package com.niknis.sample.niknissamplespringrest.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="blog_post")
public class BlogPost {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String postBody;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private StWritterDBModel stWritterDBModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	
	public StWritterDBModel getStWritterDBModel() {
		return stWritterDBModel;
	}

	public void setStWritterDBModel(StWritterDBModel stWritterDBModel) {
		this.stWritterDBModel = stWritterDBModel;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", postBody=" + postBody + "]";
	}
	
	
}
