/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 7 okt. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.ArrayList;
import java.util.List;

import com.th5.domain.model.Address;

public class UserAddressValidator implements ValidatorInterface<Address>{

	private List<AttributeError> errorList = new ArrayList<AttributeError>();
	private static String POSTALCODE_PATTERN = "[a-zA-Z0-9-\\s]{3,10}";
	private static String CITY_PATTERN = "[a-zA-Z-\\s]{3,30}";
	private static String STREET_PATTERN = "[a-zA-Z0-9-\\s]{3,30}";
	private static String HOUSENUMBER_PATTERN = "[a-zA-Z0-9-\\s]{1,6}";

	@Override
	public List<AttributeError> validate(Address address) {
		isValidPostalCode(address.getPostalCode());
		isValidCity(address.getCity());
		isValidtStreet(address.getStreet());
		isValidHouseNumber(address.getHouseNumber());
		return errorList;
	}
	
	public void isValidHouseNumber(String houseNumber) {
		
		if (houseNumber == null) {
			errorList.add(new AttributeError("houseNumber", "house number is null"));
		} else if (houseNumber.trim().length() == 0) {
			errorList.add(new AttributeError("houseNumber",
					"house number is required"));
		} else {

			if (!houseNumber.matches(HOUSENUMBER_PATTERN)) {
				errorList.add(new AttributeError("houseNumber",
						"Invalid house number"));
			}
		}
	}
	public void isValidtStreet(String street) {
		
		if (street == null) {
			errorList.add(new AttributeError("street", "street is null"));
		} else if (street.trim().length() == 0) {
			errorList.add(new AttributeError("street",
					"street is required"));
		} else {

			if (!street.matches(STREET_PATTERN)) {
				errorList.add(new AttributeError("street",
						"Invalid street"));
			}
		}
	}
	
	public void isValidCity(String city) {
		
		if (city == null) {
			errorList.add(new AttributeError("city", "city is null"));
		} else if (city.trim().length() == 0) {
			errorList.add(new AttributeError("city",
					"city is required"));
		} else {

			if (!city.matches(CITY_PATTERN)) {
				errorList.add(new AttributeError("city",
						"Invalid city"));
			}
		}
	}

	
	public void isValidPostalCode(String postalCode) {

		if (postalCode == null) {
			errorList.add(new AttributeError("postalCode", "postal code is null"));
		} else if (postalCode.trim().length() == 0) {
			errorList.add(new AttributeError("postalCode",
					"postal code is required"));
		} else {

			if (!postalCode.matches(POSTALCODE_PATTERN)) {
				errorList.add(new AttributeError("postalCode",
						"Invalid postal code adress"));
			}
		}
	}
	
	public void clearArray() {
		errorList.clear();
	}
}
