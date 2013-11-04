package com.th5.domain.util;

import java.util.Calendar;

public class CalendarRange extends Range<Calendar> {
	public CalendarRange(Calendar low, Calendar high) {
		super(low, high);
	}
	
	public Boolean withinRange(Calendar subject) {
		if(subject.compareTo(getLow()) >= 0 && subject.compareTo(getHigh()) <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
