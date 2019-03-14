package com.niknis.sample.niknissamplespringrest.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("studentExtDynFilter")
public class StudentExtDyn {

	private String password;
	private Integer libraryCardNo;
	
	private String faterName;
	private String motherName;
	private String address;
	private String city;
	private String street;
	private String zip;
	
	
	public StudentExtDyn(String password, Integer libraryCardNo, String faterName, String motherName, String address,
			String city, String street, String zip) {
		super();
		this.password = password;
		this.libraryCardNo = libraryCardNo;
		this.faterName = faterName;
		this.motherName = motherName;
		this.address = address;
		this.city = city;
		this.street = street;
		this.zip = zip;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLibraryCardNo() {
		return libraryCardNo;
	}
	public void setLibraryCardNo(Integer libraryCardNo) {
		this.libraryCardNo = libraryCardNo;
	}
	public String getFaterName() {
		return faterName;
	}
	public void setFaterName(String faterName) {
		this.faterName = faterName;
	}
	
	
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "StudentExtDyn [password=" + password + ", libraryCardNo=" + libraryCardNo + ", faterName=" + faterName
				+ ", motherName=" + motherName + ", address=" + address + ", city=" + city + ", street=" + street
				+ ", zip=" + zip + "]";
	}
	
}
