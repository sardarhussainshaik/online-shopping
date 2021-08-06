package com.cg.go.entity;

import javax.persistence.Column;

/*import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;*/
//@Table(name="customer", uniqueConstraints =
	//	@UniqueConstraint(name = "emailValidation", columnNames= "email"))

public abstract class UserEntity {
	//@NotEmpty(message = "Please provide a username")
	private String username;
	//@NotEmpty(message = "Please provide the password")
	@Column(length = 64)
	private String password;
	
	/*@Column(unique=true)
	// the required attribute should not be empty
	//@NotEmpty(message = "Phone number is required")
	// validating using regex*/
	
	//@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message= "Mobile number is invalid")
	private String mobileNumber;
	//@UniqueConstraint(columnNames= {"email"})
	//@Email(message = "Email id is incorrect")
	private String email;
	private String address;

	public UserEntity() {

	}

	public UserEntity(String username, String password, String mobileNumber, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}