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

import com.th5.domain.model.Address;
import com.th5.domain.model.validators.UserAddressValidator;
import com.th5.domain.other.AuctifyException;

public class UserRegisterValidatorTest {

	private static UserAddressValidator userAddressValidator;
	private Address address = new Address("AaAa 20", "73", "steenweg", "Amsterdam");
	
	@BeforeClass
	public static void oneTimeSetupBeforeClass(){
		userAddressValidator = new UserAddressValidator();
	}
	
	@Before
	public void setup() throws AuctifyException {
		address.setCity("Amsterdam");
		address.setHouseNumber("73");
		address.setStreet("steenweg");
		address.setPostalCode("AaAa 20");
		userAddressValidator.clearArray();
	}

	@Test
	public void testValidCity() {
		if (userAddressValidator.validate(address).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidCity() throws AuctifyException {
		address.setCity("!Amsterdam");
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullCity() throws AuctifyException {
		address.setCity(null);
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidHouseNumber() {
		if (userAddressValidator.validate(address).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidHouseNumber() throws AuctifyException {
		address.setHouseNumber("!abc %ra");
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullHouseNumber() throws AuctifyException {
		address.setHouseNumber(null);
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}

	@Test
	public void testValidStreet() {
		if (userAddressValidator.validate(address).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidStreet() throws AuctifyException {
		address.setStreet("AABCDEFGH123456");
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullStreet() throws AuctifyException {
		address.setStreet(null);
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidPostalCode() {
		if (userAddressValidator.validate(address).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidPostalCode() throws AuctifyException {
		address.setStreet("AABCDEFGH123456");
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullPostalCode() throws AuctifyException {
		address.setPostalCode(null);
		if (!(userAddressValidator.validate(address).size() > 0)) {
			fail();
		}
	}
}
	
	