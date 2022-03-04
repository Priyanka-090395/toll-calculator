package com.exam.tollfeecalculator.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

public class TollFreeDateValidator {

  private static final Set<LocalDate> TOLL_FREE_DATES = new HashSet<>();
  private static final Set<YearMonth> TOLL_FREE_MONTHS = new HashSet<>();

	static {
		TOLL_FREE_DATES.add(LocalDate.of(2022, 1, 1));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 1, 6));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 4, 2));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 4, 4));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 4, 5));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 4, 30));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 5, 13));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 5, 14));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 5, 23));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 5, 30));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 6, 6));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 6, 25));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 6, 26));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 9, 6));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 9, 14));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 12, 24));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 12, 25));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 12, 26));
		TOLL_FREE_DATES.add(LocalDate.of(2022, 12, 31));
		TOLL_FREE_MONTHS.add(YearMonth.of(2022, 7));
	
	}

	public static boolean isTollFreeDay(LocalDate date) {
		return isWeekend(date) || isFreeDay(date);
	}

	private static boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
	
	private static boolean isFreeDay(LocalDate date) {
		return TOLL_FREE_MONTHS.contains(YearMonth.from(date)) || TOLL_FREE_DATES.contains(date);
	}
	
    
}
