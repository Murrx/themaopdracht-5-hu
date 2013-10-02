package com.th5.domain.other;

public class DateConverter {
	public static java.sql.Date toSQLDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
}
