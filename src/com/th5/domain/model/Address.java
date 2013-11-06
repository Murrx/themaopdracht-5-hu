package com.th5.domain.model;

public class Address {
	
	private String postalCode, houseNumber, street, city;
	private int id;
	
	public Address(String postalCode, String houseNumber, String street, String city){
		this.postalCode = postalCode;
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
	}
	
	public Address(int id, String postalCode, String houseNumber, String street, String city){
		this(postalCode, houseNumber, street, city);
		this.id = id;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String result = 
				street + " " + houseNumber+ "\n" +
				postalCode + " " + city;
		return result;
	}
}
