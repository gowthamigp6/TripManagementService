package com.cts.ddd.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="address")
@Data
public class Address {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private long addressId;
	private String streetName;
	private String doorNo;
	private String plotNo;
	private String city;
	private String pinCode;
	
	
	public Address(){
	}

	public Address(String streetName, String doorNo, String plotNo, String city, String pinCode) {
		this.streetName = streetName;
		this.doorNo = doorNo;
		this.plotNo = plotNo;
		this.city = city;
		this.pinCode = pinCode;
	}

}
