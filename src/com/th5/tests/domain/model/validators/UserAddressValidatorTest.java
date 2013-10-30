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
import com.th5.domain.other.AuctifyException;

public class UserAddressValidatorTest {

	private static UserRegisterValidator userValidator;
	private User user = new User("test@test.nl", "Testtest1", "test", UserRights.USER);
	
	@BeforeClass
	public static void oneTimeSetupBeforeClass(){
		userValidator = new UserRegisterValidator();
	}
	
	@Before
	public void setup() {
		try{
			user.setEmail("test@test.nl");
			user.setPassword("Testtest1");
			user.setDisplayName("test");
		} catch(AuctifyException e) {
		}
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
		try {
			user.setEmail("a@.nl");
		} catch (AuctifyException e) {
		}
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullEmailAdres() {
		try {
			user.setEmail(null);
		} catch (AuctifyException e) {
		}
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
		try {
			user.setPassword("a bla 2!");
		} catch (AuctifyException e) {
		}
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullPassword() {
		try {
			user.setPassword(null);
		} catch (AuctifyException e) {
		}
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
		try {
			user.setDisplayName("a");
		} catch (AuctifyException e) {
		}
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullDisplayName() {
		try {
			user.setDisplayName(null);
		} catch (AuctifyException e) {
		}
		if (!(userValidator.validate(user).size() > 0)) {
			fail();
		}
	}
}
	
	