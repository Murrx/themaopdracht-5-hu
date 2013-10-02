package com.th5.domain.model;

import java.util.Date;

public class Person {
	
	private String firstName, lastName;
	private int gender;
	private Date birthdate;
	
	public Person(String firstName, String lastName, int gender, Date birthdate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	

}

