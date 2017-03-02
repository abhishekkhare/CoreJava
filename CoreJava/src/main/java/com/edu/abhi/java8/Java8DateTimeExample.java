package com.edu.abhi.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Java8DateTimeExample {

	public static void main(String[] args) {
		// the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println("currentDate::"+currentDate);

		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
		System.out.println("tenthFeb2014::"+tenthFeb2014);

		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
		System.out.println("firstAug2014::"+firstAug2014);
		
		// the 65th day of 2010 (2010-03-06)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
		System.out.println("sixtyFifthDayOf2010::"+sixtyFifthDayOf2010);
		
		LocalTime currentTime = LocalTime.now(); // current time
		System.out.println("currentTime::"+ currentTime);
		LocalTime midday = LocalTime.of(12, 0); // 12:00
		System.out.println("midday::"+ midday);
		LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
		System.out.println("afterMidday::"+ afterMidday);
		// 12345th second of day (03:25:45)
		
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);
		System.out.println("fromSecondsOfDay::"+ fromSecondsOfDay);
		// dates with times, e.g. 2014-02-18 19:08:37.950
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("currentDateTime::"+ currentDateTime);
		// 2014-10-02 12:30
		LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
		System.out.println("secondAug2014::"+ secondAug2014);
		// 2014-12-24 12:00
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);
		System.out.println("christmas2014::"+ christmas2014);
	}

}
