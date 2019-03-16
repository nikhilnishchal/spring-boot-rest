package com.niknis.sample.niknissamplespringrest.version;

public class StudentModelV1 {

	private String name;
	private Integer role;
	
	protected StudentModelV1() {
		
	}

	public StudentModelV1(String name, Integer role) {
		super();
		this.name = name;
		this.role = role;
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
	
	
}
