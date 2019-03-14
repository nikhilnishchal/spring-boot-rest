package com.niknis.sample.niknissamplespringrest.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about Student model")
public class Student {
	
	private Integer id;
	
	@Size(min=2, message = "Student name should be more than 2 Char")
	@ApiModelProperty(notes="Name should be more than 2 char")
	private String name;
	private Integer role;
	private String School;
	@Past
	@ApiModelProperty(notes="Birthdate should be in past only")
	private LocalDate dob;
	
	/**
	 * defined this default constructor for the time of post data error"no Creators, like default construct, exist"
	 * 
	 */
	protected Student() {
		
	}
	/**
	 * Generated constructor using fields for Student class
	 * 
	 * @param id
	 * @param name
	 * @param role
	 * @param school
	 * @param dob
	 * 
	 */
	public Student(Integer id, String name, Integer role, String school, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		School = school;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getSchool() {
		return School;
	}
	public void setSchool(String school) {
		School = school;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", role=" + role + ", School=" + School + ", dob=" + dob + "]";
	}
	
	

}
