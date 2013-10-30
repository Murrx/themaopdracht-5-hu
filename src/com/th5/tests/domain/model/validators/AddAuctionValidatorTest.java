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

import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;
import com.th5.domain.model.validators.AddAuctionValidator;

public class AddAuctionValidatorTest {

	private static AddAuctionValidator addAuctionValidator;
	private Auction auction = new Auction(null, 0, Category.BOOKS, "How to make a junit test", "de test", 1, null); 
		
	@BeforeClass
	public static void oneTimeSetupBeforeClass(){
		addAuctionValidator = new AddAuctionValidator();
	}
	
	@Before
	public void setup() {
		Calendar startTime = Calendar.getInstance();
		startTime.set(2013, 10, 10, 10, 0, 0);
		Calendar endTime = Calendar.getInstance();
		endTime.set(2013, 10, 11, 10, 0, 0);
		auction.setStartTime(startTime);
		auction.setEndTime(endTime);
		auction.setStartBid(0);
		auction.setCategory(Category.BOOKS);
		auction.getProduct().setDescription("de test");
		auction.getProduct().setName("How to make a junit test");
		addAuctionValidator.clearArray();
	}

	@Test
	public void testValidStartEnEindTime() {
		if (addAuctionValidator.validate(auction).size() > 0) {
			fail();
		}
	}
	
	public void testInvalidEndTimeBeforeStartTime() { 
		
		Calendar endTime = Calendar.getInstance();
		endTime.set(2013, 10, 9, 10, 0, 0);
		auction.setEndTime(endTime);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testInValidEndTime() {
		Calendar endTime = Calendar.getInstance();
		endTime.set(2013, 10, 10, 10, 10, 10);
		auction.setEndTime(endTime);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullEndTime() {
		auction.setEndTime(null);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	
	
	@Test
	public void testValidStartBid() {
		if (addAuctionValidator.validate(auction).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidStartBid() {
		auction.setStartBid(-1);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}

	@Test
	public void testValidCategory() {
		if (addAuctionValidator.validate(auction).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidCategory() {
		auction.setCategory(Category.fromString("aa"));
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullCategory() {
		auction.setCategory(null);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidDescription() {
		if (addAuctionValidator.validate(auction).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidDescription() {
		auction.getProduct().setDescription(" ");
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullDescription() {
		auction.getProduct().setDescription(null);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testValidName() {
		if (addAuctionValidator.validate(auction).size() > 0) {
			fail();
		}
	}
	
	@Test
	public void testInValidName() {
		auction.getProduct().setName(" ");
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
	
	@Test
	public void testNullName() {
		auction.getProduct().setName(null);
		if (!(addAuctionValidator.validate(auction).size() > 0)) {
			fail();
		}
	}
}
	
	