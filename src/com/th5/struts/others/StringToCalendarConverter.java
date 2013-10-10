package com.th5.struts.others;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class StringToCalendarConverter extends StrutsTypeConverter {

    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public Object convertFromString(Map context, String[] strings, Class toClass) {     
        if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
            return null;
        }

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DATETIME_FORMAT.parse(strings[0]));
            return calendar;
        } catch (ParseException e) {
            throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);
        }
    }

    public String convertToString(Map context, Object calendar) {
        if (calendar != null && calendar instanceof Calendar) {         
            return DATETIME_FORMAT.format(calendar);
        } else {
            return null;
        }
    }
}