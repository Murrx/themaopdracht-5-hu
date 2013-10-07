/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 29 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.tests.domain.model.validators;

import org.junit.Before;
import org.junit.BeforeClass;

import com.th5.domain.model.Person;
import com.th5.domain.model.validators.UserPersonValidator;

public class UserPersonValidatorTest {

	private static UserPersonValidator userPersonValidator;
	private Person person = new Person("Sven", "Wald", 1, null);
	
	@BeforeClass
	public static void oneTimeSetupBeforeClass(){
		userPersonValidator = new UserPersonValidator();
	}
	
	@Before
	public void setup() {
		person.setFirstName("Sven");
		person.setLastName("Wald");
		person.setGender(1);
		//person.getBirthdate();
		userPersonValidator.clearArray();	
	}

	
}
	
	