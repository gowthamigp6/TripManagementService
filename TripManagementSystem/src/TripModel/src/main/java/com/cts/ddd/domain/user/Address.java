package com.cts.ddd.domain.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cts.ddd.domain.shared.ValueObject;
import lombok.Data;

@Document(collection="address")
@Data
public class Address implements ValueObject<Address> {
	
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




	@Override
	public boolean sameValueAs(Address other) {
		
		return other != null && new EqualsBuilder().
			      append(this.streetName, other.streetName).
			      append(this.doorNo, other.doorNo).
			      append(this.plotNo, other.plotNo).
			      append(this.city, other.city).
			      append(this.pinCode, other.pinCode).
			      isEquals();
	}
}
