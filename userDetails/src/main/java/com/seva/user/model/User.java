package com.seva.user.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

public class User {
	
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	@NotNull
	private String email;
	@NotNull
	private Address address = new Address();
	@Indexed(direction = IndexDirection.ASCENDING, unique = true)
	@NotNull
	private String phoneNum;
	@NotNull
	private String age;
	@NotNull
	private String imagesrc= null;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emailAddr) {
		this.email = emailAddr;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getImagesrc() {
		return imagesrc;
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}

}
