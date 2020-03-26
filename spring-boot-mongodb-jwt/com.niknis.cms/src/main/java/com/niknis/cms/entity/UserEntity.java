package com.niknis.cms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.niknis.cms.model.User;

@Document(collection = "user")
public class UserEntity {
	
	@Id
    public String id;
	
	public String name;
	public String email;
	public String password;
	
	public UserEntity() {}
	
	public UserEntity(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
    public String toString() {
		return String.format(
                "User[id=%s, name=%s, email=%s, password=%s]", id, name,email,password);
	}

	public User format() {
		return new User(this.id, this.name, this.email, this.password);
	}
}
