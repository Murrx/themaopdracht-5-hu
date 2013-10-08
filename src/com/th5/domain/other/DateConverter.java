package com.th5.domain.other;

import java.util.Calendar;

public class DateConverter {
	public static java.sql.Date dateToSQLDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Date calendarToSQLDate(java.util.Calendar calendar){
		return new java.sql.Date(calendar.getTimeInMillis());
	}
	
	public static java.util.Calendar SQLDateToCalendar(java.sql.Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		return calendar;
	}
}
