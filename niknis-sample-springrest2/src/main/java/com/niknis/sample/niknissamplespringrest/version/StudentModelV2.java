package com.niknis.sample.niknissamplespringrest.version;

public class StudentModelV2 {

	private Name name;
	private Integer role;
	
	protected StudentModelV2() {
		
	}

	public StudentModelV2(Name name, Integer role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
	
}
