package com.cts.ddd.domain.user;


import org.apache.commons.lang.builder.EqualsBuilder;

import com.cts.ddd.domain.shared.ValueObject;
import lombok.Data;

/**
 * @author gowthami
 */

@Data
public class FullName implements ValueObject<FullName> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;

	public FullName(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FullName)) return false;

		FullName fullName = (FullName) o;

		if (firstName!= null ? !firstName.equals(fullName.firstName) : fullName.firstName!= null)
			return false;
		return lastName != null ? lastName.equals(fullName.lastName) : fullName.lastName == null;

	}

	@Override
	public int hashCode() {
		int result = firstName!= null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}


	@Override
	public boolean sameValueAs(FullName other) {
		return other != null && new EqualsBuilder().append(this.firstName, other.firstName)
				.append(this.lastName, other.lastName).isEquals();
	}
}
