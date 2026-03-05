package com.addressbook.addressbookapp.dto;

public class User {
	//first and last names, address,
	//city, state, zip, phone number and
	//email...
	
	private long userId = 101;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String ZIP;
	private String number;
	private String email;
	
	public User(String firstName, String lastName, String address, String city, String state, String zIP, String number, String email) {
		this.userId +=1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.ZIP = zIP;
		this.number = number;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", ZIP=" + ZIP + ", number=" + number + ", email=" + email
				+ "]";
	}
}