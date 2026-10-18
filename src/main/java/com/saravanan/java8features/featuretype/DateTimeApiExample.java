package com.saravanan.java8features.featuretype;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApiExample {

	public void dataTimeApi() {

		System.out.println("get Current Date and Time :- ");
		System.out.println("Local Date - " + LocalDate.now());
		System.out.println("Local Time - " + LocalTime.now());
		System.out.println("Local DateTime - " + LocalDateTime.now());
		System.out.println("Zoned DateTime - " + ZonedDateTime.now());
		System.out.println("Instant - " + Instant.now());

		System.out.println("Specific Date and Time :- ");
		System.out.println("Specific LocalDate - " + LocalDate.of(1999, 12, 16));
		System.out.println("Specific LocalTime - " + LocalTime.of(11, 30, 55));
		System.out.println("Specific LocalDateTime - " + LocalDateTime.of(1999, 12, 16, 11, 30, 55));
		System.out.println("Specific LocalDateTime - " + LocalDateTime.of(LocalDate.of(1999, 12, 16), LocalTime.of(11,
				0)));
		System.out.println("Specific LocalTime - " + ZonedDateTime.of(1999, 12, 16, 6, 30, 55, 0, ZoneId
				.systemDefault()));

		System.out.println("Add or Minus [Date and Time] :- ");
		System.out.println("Add or Minus [LocalDate]" + LocalDate.now().plusYears(5).plusMonths(2).plusDays(1));
		System.out.println("Add or Minus [LocalDate]" + LocalDate.now().minusWeeks(5).minusDays(10));
		System.out.println("Add or Minus [LocalTime]" + LocalTime.now().plusHours(4).plusMinutes(30));
		System.out.println("Add or Minus [LocalTime]" + LocalTime.now().minusMinutes(30));
		System.out.println("Add or Minus [Instant]" + Instant.now().plusSeconds(30));

		System.out.println("Compare Date :- ");
		LocalDate fromDate = LocalDate.of(2025, 4, 1);
		LocalDate toDate = LocalDate.of(2025, 5, 1);
		System.out.println("From Date Less Than ToDate - " + fromDate.isBefore(toDate));
		System.out.println("From Date Greater Than ToDate - " + fromDate.isAfter(toDate));

		System.out.println("Time Difference :- ");
		LocalTime now = LocalTime.now();
		LocalTime plusHours = LocalTime.now().plusHours(7);
		System.out.println("Time Difference to Days - " + Duration.between(now, plusHours).toDays());
		System.out.println("Time Difference to Hours - " + Duration.between(now, plusHours).toHours());
		System.out.println("Time Difference to Secounds - " + Duration.between(now, plusHours).toSeconds());
		System.out.println("Time Difference to Millisecounds - " + Duration.between(now, plusHours).toMillis());
		System.out.println("Time Difference to Nanos - " + Duration.between(now, plusHours).toNanos());

		System.out.println("Date Difference :- ");
		LocalDate fromLocalDate = LocalDate.now();
		LocalDate toLocalDate = LocalDate.now().plusYears(5).plusDays(2);

		System.out.println("Period Difference get Year - " + Period.between(fromLocalDate, toLocalDate).getYears());
		System.out.println("Period Difference get Month - " + Period.between(fromLocalDate, toLocalDate).getMonths());
		System.out.println("Period Difference get Days - " + Period.between(fromLocalDate, toLocalDate).getDays());

		System.out.println("Data Time Formatter :- ");
		System.out.println("LocalDate Formatter - " + LocalDate.now().format(DateTimeFormatter.ofPattern(
				"dd-MMM-yyyy")));
		System.out.println("LocalTime Formatter - " + LocalTime.now().format(DateTimeFormatter.ofPattern(
				"hh:mm:ss a")));
		System.out.println("LocalDateTime Formatter - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(
				"dd-MMM-yyyy hh:mm:ss a")));

		System.out.println("LocalDate Parse and Formatter - " + LocalDate.parse("2025-05-28").format(DateTimeFormatter
				.ofPattern("dd-MMM-yyyy")));
		System.out.println("LocalTime Parse and Formatter - " + LocalTime.parse("01:30:00").format(DateTimeFormatter
				.ofPattern("hh:mm:ss a")));
		System.out.println("LocalDateTime Parse and Formatter - " + LocalDateTime.parse("2025-08-28 01:30:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).format(DateTimeFormatter.ofPattern(
						"dd-MMM-yyyy hh:mm:ss a")));

	}

}
