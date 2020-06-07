package com.cts.ddd.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "user")
@Data
public class User {

	@Id
	private String userId;
	private String password;
	private String role;
	
	private FullName fullName;
	private ContactInformation contactInformation;
	
	@DBRef(db="address",lazy=true)
	private Address address;
	
	
	public User() {
	}

	public User(String userId, String password, String role, FullName fullName, ContactInformation contactInformation,
			Address address) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.contactInformation = contactInformation;
		this.address = address;
	}
	
	
}
