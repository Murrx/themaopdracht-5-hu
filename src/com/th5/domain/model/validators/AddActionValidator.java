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

import org.apache.jasper.tagplugins.jstl.core.If;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.th5.domain.model.Auction;
import com.th5.domain.model.User;

public class AddActionValidator implements ValidatorInterface<Auction> {

	private List<AttributeError> errorList = new ArrayList<AttributeError>();

	@Override
	public List<AttributeError> validate(Auction auction) {
		isValidCalendarTime(auction.getEndTime(), auction.getStartTime());
		return errorList;
	}

	public void isValidCalendarTime(Calendar endTime, Calendar startTime) {

		if (endTime == null) {
			errorList
					.add(new AttributeError("endTime", "end time is required"));
		}
		
		if (startTime == null) {
			errorList
			.add(new AttributeError("endTime", "start time is null!"));
		}

		if (endTime != null && startTime != null) {

			if (endTime.before(startTime)) {
				errorList.add(new AttributeError("endTime",
						"end time is before start time"));
			}
			if (!(daysBetween(startTime.getTime(), endTime.getTime()) >= 1)) {
				errorList.add(new AttributeError("endTime", "end time has to be atleast 1 day after the start time"));
			}
		}

	}
	
	public void isValidName(String name) {
		if (name == null) {
			
		}
		if ("".equals(name.trim())) {
			
		}
	}
	
	public void isValidDescription() {
		
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

	}

	public void clearArray() {
		errorList.clear();
	}
}
