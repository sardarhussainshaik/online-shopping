package com.cg.go.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
//@Table(name="customer", uniqueConstraints = @UniqueConstraint(name = "emailValidation", columnNames= "email"))
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = ("email")))
public class CustomerEntity  {

	@Id
	//@UniqueConstraint(columnNames= {"email"})
	private int customerId;
	private String customerName;
	private String password;
	private String email;
	private long phonenumber;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	public CustomerEntity() { 

	}

	public CustomerEntity(int customerId, String customerName, String password, String email, long phonenumber,
			String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	

	public CustomerEntity(int customerId, String customerName, String password, String email, long phonenumber,
			String address, String city, String state, String pincode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerEntity other = (CustomerEntity) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	

}
	
	


	
	

