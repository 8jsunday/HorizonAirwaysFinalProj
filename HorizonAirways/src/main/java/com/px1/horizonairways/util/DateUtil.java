package com.px1.horizonairways.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String formatDate(Date d){
		
		String[] monthNames = { "January", "February", "March", "April", "May", "June", 
								"July", "August", "September", "October", "November",
								"December" };
		
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(d);
	return monthNames[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR);
	
	}

}
