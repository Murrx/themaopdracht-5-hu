/*
 * Developer : Joris Rijkes (Joris_Rijkes@gmail.com)
 * Date : 24 sep. 2013
 * All code (c)2013 Joris Rijkes inc. all rights reserved
 */

package com.th5.domain.model.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.th5.domain.model.Auction;
import com.th5.domain.model.Category;

public class AddAuctionValidator implements ValidatorInterface<Auction> {

	private List<AttributeError> errorList = new ArrayList<AttributeError>();

	@Override
	public List<AttributeError> validate(Auction auction) {
		isValidCalendarTime(auction.getEndTime(), auction.getStartTime());
		isValidCategory(auction.getCategory());
		isValidDescription(auction.getProduct().getDescription());
		isValidName(auction.getProduct().getName());
		isValidStartBid(auction.getStartBid());
		return errorList;
	}

	public void isValidCalendarTime(Calendar endTime, Calendar startTime) {

		if (endTime == null) {
			errorList.add(new AttributeError("end_time", "end time is required"));
		}

		if (startTime == null) {
			errorList.add(new AttributeError("end_time", "start time is null!"));
		}

		if (endTime != null && startTime != null) {

			if (endTime.before(startTime)) {
				errorList.add(new AttributeError("end_time",
						"end time is before start time"));
			}
			if (!(daysBetween(startTime.getTime(), endTime.getTime()) >= 1)) {
				errorList.add(new AttributeError("end_time", "end time has to be atleast 1 day after the start time"));
			}
		}

	}
	
	public void isValidStartBid(int startBid) {
		if (startBid < 0) {
			errorList
			.add(new AttributeError("price", "price cannot be negative"));
		}
	}

	public void isValidName(String name) {
		if (name == null) {
			errorList.add(new AttributeError("name", "name is required"));
		}
		else if ("".equals(name.trim())) {
			errorList.add(new AttributeError("name", "name is required!"));
		}
	}

	public void isValidDescription(String description) {
		if (description == null) {
			errorList.add(new AttributeError("description", "description is required!"));
		}
		else if ("".equals(description.trim())) {
			errorList.add(new AttributeError("description", "description is required!"));
		}
	}
	
	public void isValidCategory(Category category) {
		if (category == null) {
			errorList.add(new AttributeError("category", "category is required!"));
		}
		else if ("".equals(category)) {
			errorList.add(new AttributeError("category", "category is required!"));
		}
	}
	

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

	}

	public void clearArray() {
		errorList.clear();
	}
}
