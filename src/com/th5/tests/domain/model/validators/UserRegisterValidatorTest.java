/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 29 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.tests.domain.model.validators;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.th5.domain.model.User;
import com.th5.domain.model.UserRights;
import com.th5.domain.model.validators.UserRegisterValidator;

public class UserRegisterValidatorTest {

	private static UserRegisterValidator userValidator;
	private User user = new User("test@test.nl", "Testtest1", "test", UserRights.USER);
	
	@BeforeClass
	public static void oneTimeSetupBeforeClass(){
		userValidator = new UserRegisterValidator();
	}
	
	@Before
	public void setup() {
		user.setEmail("test@test.nl");
		user.setPassword("Testtest1");
		user.setDisplayName("test");
		userValidator.clearArray();	
	}

	@Test
	public void testValidEmailAdres() {
		if (userValidator.validate(user).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidEmailAdres() {
		user.setEmail("a@.nl");
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullEmailAdres() {
		user.setEmail(null);
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidPassword() {
		if (userValidator.validate(user).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidPassword() {
		user.setPassword("a bla 2!");
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullPassword() {
		user.setPassword(null);
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidDisplayName() {
		if (userValidator.validate(user).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidDisplayName() {
		user.setDisplayName("a");
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullDisplayName() {
		user.setDisplayName(null);
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
}
	
	