/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 29 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.tests.domain.model.validators;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		Calendar birthdate = Calendar.getInstance();
		birthdate.set(1990, 10, 10);
		person.setBirthdate(birthdate.getTime());
		userPersonValidator.clearArray();	
	}
	
	@Test
	public void testValidFirstName() {
		if (userPersonValidator.validate(person).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidFirstName() {
		person.setFirstName("!0.");
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullFirstName() {
		person.setFirstName(null);
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}

	@Test
	public void testValidLastName() {
		if (userPersonValidator.validate(person).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidLastName() {
		person.setLastName("0abcdef");
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullLastName() {
		person.setLastName(null);
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidGender() {
		if (userPersonValidator.validate(person).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidGender() {
		person.setGender(10);
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNegatiefGender() {
		person.setGender(-1);
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidBirthdate() {
		if (userPersonValidator.validate(person).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testBirthdateAfterCurrentTime() {
		Calendar fouteBirthdate = Calendar.getInstance();
		fouteBirthdate.set(2999, 10, 10);
		person.setBirthdate(fouteBirthdate.getTime());
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullBirthdate() {
		person.setBirthdate(null);
		if (!(userPersonValidator.validate(person).size() > 0)) {
			fail();
		}
	}
}
	
	