package com.cts.ddd.domain.user;

import org.apache.commons.lang.builder.EqualsBuilder;
import com.cts.ddd.domain.shared.ValueObject;

import lombok.Data;

@Data
public class ContactInformation implements ValueObject<ContactInformation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String telephoneNo;

	@Override
	public boolean sameValueAs(ContactInformation other) {
		return other != null && new EqualsBuilder().append(this.emailId, other.emailId)
				.append(this.telephoneNo, other.telephoneNo).isEquals();
	}

}
