package com.kwler.commons.datetime;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class DatetimeService {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String TIMEZONE = "Asia/Singapore";
	private static final DateTimeZone DATETIMEZONE = DateTimeZone.forID(TIMEZONE);
	
	private DateTimeZone extractTimeZone(String...timezone){
		return timezone.length == 0 ? DATETIMEZONE : DateTimeZone.forID(timezone[0]);
	}
	
	public long now(){
		return new DateTime().getMillis();
	}
	
	public Date toJavaDate(){
		return new DateTime().toDate();
	}
	
	public Date toJavaDate(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).toDate();
	}
	
	public String todayString(String...timezone){		
		return timeString(DATE_FORMAT, now(), timezone);
	}
	
	public String nowString(String...timezone){
		return timeString(TIMESTAMP_FORMAT, now(), timezone);
	}
	
	public String dateString(long epochMillis, String...timezone){
		return timeString(DATE_FORMAT, epochMillis, timezone);
	}
	
	public String timeString(long epochMillis, String...timezone){
		return timeString(TIMESTAMP_FORMAT, epochMillis, timezone);
	}
	
	public String timeString(String format, String...timezone){
		return timeString(format, now(), timezone);
	}
	
	public String timeString(String format, long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).toString(format);				
	}
	
	public long addDay(int days, boolean atStartOfDay, String...timezone){
		return addDay(now(), days, atStartOfDay, timezone);
	}
	
	public long addDay(long epochMillis, int days, boolean atStartOfDay, String...timezone){
		
		DateTime addedDatetime = new DateTime(epochMillis, extractTimeZone(timezone))
											.plusDays(days);
		
		if(atStartOfDay) return addedDatetime.withTimeAtStartOfDay().getMillis();
		else return addedDatetime.getMillis();
		
	}
	
	public long addDay(int days, int hours, boolean atstartOfHour, String...timezone){
		return addDay(now(), days, hours, atstartOfHour, timezone);
	}
	
	public long addDay(long epochMillis, int days, int hours, boolean atstartOfHour, String...timezone){
		
		DateTime addedDatetime = new DateTime(epochMillis, extractTimeZone(timezone))
											.plusDays(days)
											.plusHours(hours);
		
		if(atstartOfHour) return addedDatetime
											.withMinuteOfHour(0)
											.withSecondOfMinute(0)
											.withMillisOfSecond(0)
											.getMillis();
		else return addedDatetime.getMillis();
		
	}
	
	public long addDay(int days, int hours, int minutes, boolean atStartOfMinute, String...timezone){
		return addDay(now(), days, hours, minutes, atStartOfMinute, timezone);
	}
	
	public long addDay(long epochMillis, int days, int hours, int minutes, boolean atStartOfMinute, String...timezone){
		
		DateTime addedDatetime = new DateTime(epochMillis, extractTimeZone(timezone))
											.plusDays(days)
											.plusHours(hours)
											.plusMinutes(minutes);
		
		if(atStartOfMinute) return addedDatetime
												.withSecondOfMinute(0)
												.withMillisOfSecond(0)
												.getMillis();
		else return addedDatetime.getMillis();
		
	}
	
	public long addDay(int days, int hours, int minutes, int seconds, boolean atStartOfSecond, String...timezone){
		return addDay(now(), days, hours, minutes, seconds, atStartOfSecond, timezone);
	}
	
	public long addDay(long epochMillis, int days, int hours, int minutes, int seconds, boolean atStartOfSecond, String...timezone){
		
		DateTime addedDatetime = new DateTime(epochMillis, extractTimeZone(timezone))
											.plusDays(days)
											.plusHours(hours)
											.plusMinutes(minutes)
											.plusSeconds(seconds);
		
		if(atStartOfSecond) return addedDatetime
												.withMillisOfSecond(0)
												.getMillis();
		else return addedDatetime.getMillis();
		
	}
	
	public long addDay(int days, int hours, int minutes, int seconds, int millis, String...timezone){
		return addDay(now(), days, hours, minutes, seconds, millis, timezone);
	}
	
	public long addDay(long epochMillis, int days, int hours, int minutes, int seconds, int millis, String...timezone){		
		return new DateTime(epochMillis, extractTimeZone(timezone))
											.plusDays(days)
											.plusHours(hours)
											.plusMinutes(minutes)
											.plusSeconds(seconds)
											.plusMillis(millis)
											.getMillis();				
	}
	
	public int getYear(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getYear();
	}
	
	public int getMonth(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getMonthOfYear();
	}
	
	public int getDate(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getDayOfMonth();
	}
	
	public int getDayOfWeek(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getDayOfWeek();
	}
	
	public int getHour(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getHourOfDay();
	}
	
	public int getMinute(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getMinuteOfHour();
	}
	
	public int getSeconds(long epochMillis, String...timezone){
		return new DateTime(epochMillis, extractTimeZone(timezone)).getSecondOfMinute();
	}
	
	public long getEpochMillis(int year, int month, int date, String...timezone){
		return getEpochMillis(year, month, date, 0, 0, 0, 0, timezone);
	}
	
	public long getEpochMillis(int year, int month, int date, int hour, String...timezone){
		return getEpochMillis(year, month, date, hour, 0, 0, 0, timezone);
	}
	
	public long getEpochMillis(int year, int month, int date, int hour, int minute, String...timezone){
		return getEpochMillis(year, month, date, hour, minute, 0, 0, timezone);
	}
	
	public long getEpochMillis(int year, int month, int date, int hour, int minute, int second, String...timezone){
		return getEpochMillis(year, month, date, hour, minute, second, 0, timezone);
	}
	
	public long getEpochMillis(int year, int month, int date, int hour, int minute, int second, int millis, String...timezone){
		return new DateTime(extractTimeZone(timezone))
				.withYear(year)
				.withMonthOfYear(month)
				.withDayOfMonth(date)
				.withHourOfDay(hour)
				.withMinuteOfHour(minute)
				.withSecondOfMinute(second)
				.withMillisOfSecond(millis)
				.getMillis();
	}
	
}
