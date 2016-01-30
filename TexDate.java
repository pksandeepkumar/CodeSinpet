package com.example.test;

import java.util.Calendar;
/**
 * 
 * @author edinette <br>
 * time format 1 : 05:10 12hr<br>
 * time format 2 : 05:10 PM 12hr<br>
 * time format 3 : 05:10 pm 12hr<br>
 */
public class TexDate {
	
	Calendar calendar;
	long timeInMillisecond;
	
	public TexDate( Calendar calendar) {
		this.calendar = calendar;
		this.timeInMillisecond = calendar.getTimeInMillis();
				
	}
	
	public TexDate(long timeInMillisecond) {
		this.timeInMillisecond = timeInMillisecond;
		this.calendar.setTimeInMillis(timeInMillisecond);
				
	}
	
	/**
	 * 
	 * @return format 05:10 12hr format
	 */
	public String getTime_format1() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int am_pm = calendar.get(Calendar.AM_PM);
		
		if(am_pm ==  Calendar.PM) {
			hour = hour - 12;
		}
		return setPadding(hour) + ":" + setPadding(minute);
	}
	
	/**
	 * 
	 * @return format 05:10 PM 12hr format
	 */
	public String getTime_format2() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int am_pm = calendar.get(Calendar.AM_PM);
		
		if(am_pm ==  Calendar.PM) {
			hour = hour - 12;
		}
		return setPadding(hour) + ":" + setPadding(minute) + ((am_pm == Calendar.AM) ? "AM" : "PM");
	}
	
	/**
	 * 
	 * @return format 05:10 pm 12hr format
	 */
	public String getTime_format3() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int am_pm = calendar.get(Calendar.AM_PM);
		
		if(am_pm ==  Calendar.PM) {
			hour = hour - 12;
		}
		return setPadding(hour) + ":" + setPadding(minute) + ((am_pm == Calendar.AM) ? "am" : "pm");
	}
	
	/**
	 * 
	 * @return format 25/10/2014
	 */
	public String getDate_format1() {
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int month = calendar.get(Calendar.MONTH);
		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR); 
		
		return setPadding(day_of_month) + "/" + setPadding(month) + "/" + year;
	}
	
	/**
	 * 
	 * @return format 25-10-2014
	 */
	public String getDate_format2() {
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int month = calendar.get(Calendar.MONTH);
		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR); 
		
		return setPadding(day_of_month) + "-" + setPadding(month) + "-" + year;
	}
	
	/**
	 * 
	 * @return format 25-Sep-2014
	 */
	public String getDate_format3() {
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int month = calendar.get(Calendar.MONTH);
		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR); 
		
		return setPadding(day_of_month) + "-" + getMonthShortName(month) + "-" + year;
	}
	
	
	public String getHourIn12hr() {
		int hour = calendar.get(Calendar.HOUR);
		return setPadding(hour);
	}
	
	public String getHourIn24hr() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return setPadding(hour);
	}
	
	
	public String getMinute() {
		int minute = calendar.get(Calendar.MINUTE);
		return setPadding(minute);
	}
	
	public String getMonthShortName() {
		int month = calendar.get(Calendar.MONTH);
		return getMonthShortName(month);
	}
	
	public String getMonthFullName() {
		int month = calendar.get(Calendar.MONTH);
		return getMonthFullName(month);
	}
	
	public String getMonth() {
		int month = calendar.get(Calendar.MONTH);
		return setPadding(month);
	}
	
	public String getDay() {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return setPadding(day);
	}
	
	public String getDayFullName() {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return getDayFullName(day);
	}
	
	public String getDayShortName() {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return getDayShortName(day);
	}
	
	public String getYear() {
		int year = calendar.get(Calendar.YEAR);
		return getDayShortName(year);
	}
	
	public String getAmPm() {
		int am_pm = calendar.get(Calendar.AM_PM);
		return ((am_pm == Calendar.AM) ? "AM" : "PM");
	}
	
	private String setPadding(int num) {
		return (num < 10) ? "0" + num : "" + num;
	}
	
	private String getDayFullName(int day) {

		switch (day) {
		case Calendar.SUNDAY:
			return "Sunday";
		case Calendar.MONDAY:
			return "Monday";
		case Calendar.TUESDAY:
			return "Tuesday";
		case Calendar.WEDNESDAY:
			return "Wednesday";
		case Calendar.THURSDAY:
			return "Thursday";
		case Calendar.FRIDAY:
			return "Friday";
		case Calendar.SATURDAY:
			return "Saturday";
		}

		return "Sunday";
	}
	
	private String getDayShortName(int day) {

		switch (day) {
		case Calendar.SUNDAY:
			return "Sun";
		case Calendar.MONDAY:
			return "Mon";
		case Calendar.TUESDAY:
			return "Tue";
		case Calendar.WEDNESDAY:
			return "Wed";
		case Calendar.THURSDAY:
			return "Thu";
		case Calendar.FRIDAY:
			return "Fri";
		case Calendar.SATURDAY:
			return "Sat";
		}

		return "Sun";
	}

	private String getMonthFullName(int month) {

		switch (month) {
		case Calendar.JANUARY:
			return "January";
		case Calendar.FEBRUARY:
			return "February";
		case Calendar.MARCH:
			return "March";
		case Calendar.APRIL:
			return "April";
		case Calendar.MAY:
			return "May";
		case Calendar.JUNE:
			return "June";
		case Calendar.JULY:
			return "July";
		case Calendar.AUGUST:
			return "August";
		case Calendar.SEPTEMBER:
			return "September";
		case Calendar.OCTOBER:
			return "October";
		case Calendar.NOVEMBER:
			return "November";
		case Calendar.DECEMBER:
			return "December";
		}

		return "January";
	}
	
	private String getMonthShortName(int month) {

		switch (month) {
		case Calendar.JANUARY:
			return "Jan";
		case Calendar.FEBRUARY:
			return "Feb";
		case Calendar.MARCH:
			return "Mar";
		case Calendar.APRIL:
			return "Apr";
		case Calendar.MAY:
			return "May";
		case Calendar.JUNE:
			return "Jun";
		case Calendar.JULY:
			return "Jul";
		case Calendar.AUGUST:
			return "Aug";
		case Calendar.SEPTEMBER:
			return "Sep";
		case Calendar.OCTOBER:
			return "Oct";
		case Calendar.NOVEMBER:
			return "Nov";
		case Calendar.DECEMBER:
			return "Dec";
		}

		return "Jan";
	}

}
