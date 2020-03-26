package com.niknis.cms.model;

import com.mongodb.BasicDBObject;
import com.niknis.cms.entity.UserEntity;

public class User {
	
	private String id;
	
	private String name;
	private String email;
	private String password;
	
	public User() {}
	
	public User(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BasicDBObject format() {
		BasicDBObject document = new BasicDBObject();
		document.put("name", this.name);
		document.put("email", this.email);
		document.put("password", this.password);
		
		return document;
	}
	
	public UserEntity formatUserEntity() {
		return new UserEntity(this.id, this.name, this.email, this.password);
	}
}
