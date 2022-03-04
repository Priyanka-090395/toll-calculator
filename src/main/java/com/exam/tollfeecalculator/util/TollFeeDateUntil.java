package com.exam.tollfeecalculator.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TollFeeDateUntil {


	public static LocalTime toTime(String date) {
		return LocalTime.parse(date);
	}

	public static LocalDateTime toLocalDateTime(String date) {
		return LocalDateTime.parse(date);
	}

	public static LocalDateTime[] toLocalDateTimes(String... dates) {
		List<LocalDateTime> results = new ArrayList<>();
		for (String date : dates) {
			results.add(LocalDateTime.parse(date));
		}
		return results.toArray(new LocalDateTime[results.size()]);
	}

}
