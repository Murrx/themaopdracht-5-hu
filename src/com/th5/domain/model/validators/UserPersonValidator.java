/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 7 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.th5.domain.model.Person;

public class UserPersonValidator implements ValidatorInterface<Person> {

	private List<AttributeError> errorList = new ArrayList<AttributeError>();
	// private static String POSTALCODE_PATTERN = "[a-zA-Z0-9-\\s]{3,10}";
	private static String NAME_PATTERN = "[a-zA-Z-\\s]{3,20}";

	// private static String HOUSENUMBER_PATTERN = "[a-zA-Z0-9-\\s]{1,6}";

	@Override
	public List<AttributeError> validate(Person person) {
		isValidBirthDate(person.getBirthdate());
		isValidFirstName(person.getFirstName());
		isValidGender(person.getGender());
		isValidLastName(person.getLastName());
		return errorList;
	}

	public void isValidFirstName(String firstName) {

		if (firstName == null) {
			errorList
					.add(new AttributeError("firstName", "first name is null"));
		} else if (firstName.trim().length() == 0) {
			errorList.add(new AttributeError("firstName",
					"first name is required"));
		} else {

			if (!firstName.matches(NAME_PATTERN)) {
				errorList.add(new AttributeError("firstName",
						"Invalid first name"));
			}
		}
	}

	public void isValidLastName(String lastName) {

		if (lastName == null) {
			errorList.add(new AttributeError("lastName", "last name is null"));
		} else if (lastName.trim().length() == 0) {
			errorList.add(new AttributeError("lastName",
					"last name is required"));
		} else {

			if (!lastName.matches(NAME_PATTERN)) {
				errorList.add(new AttributeError("lastName",
						"Invalid last name"));
			}
		}
	}

	public void isValidGender(int gender) {

		if (gender == 0 || gender == 1) {
			errorList.add(new AttributeError("gender",
					"gender is required/invalid"));
		}
	}

	public void isValidBirthDate(Date birthdate) {

		if (birthdate == null) {
			errorList.add(new AttributeError("birthdate",
					"birthdate is required"));
		} else if (!birthdate.before(Calendar.getInstance().getTime())) {
			errorList.add(new AttributeError("birthdate",
					"birthdate is required"));
		}

	}

	public void clearArray() {
		errorList.clear();
	}
}
