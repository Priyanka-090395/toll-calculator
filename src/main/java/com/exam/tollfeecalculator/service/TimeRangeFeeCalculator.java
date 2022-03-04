package com.exam.tollfeecalculator.service;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.exam.tollfeecalculator.model.TimeRange;
import java.util.Map.Entry;

import static com.exam.tollfeecalculator.util.TollFeeDateUntil.toTime;

public class TimeRangeFeeCalculator {
	private static final Map<TimeRange, Integer> TIME_RANGE = new LinkedHashMap<>();

	static {
		TIME_RANGE.put(new TimeRange(toTime("06:00"), toTime("06:29")), 8);
		TIME_RANGE.put(new TimeRange(toTime("06:30"), toTime("06:59")), 13);
		TIME_RANGE.put(new TimeRange(toTime("07:00"), toTime("08:29")), 18);
		TIME_RANGE.put(new TimeRange(toTime("08:30"), toTime("09:39")), 13);
		TIME_RANGE.put(new TimeRange(toTime("09:30"), toTime("09:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("10:30"), toTime("10:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("11:30"), toTime("11:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("12:30"), toTime("12:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("13:30"), toTime("13:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("14:30"), toTime("14:59")), 8);
		TIME_RANGE.put(new TimeRange(toTime("15:00"), toTime("15:29")), 13);
		TIME_RANGE.put(new TimeRange(toTime("15:30"), toTime("16:59")), 18);
		TIME_RANGE.put(new TimeRange(toTime("17:00"), toTime("17:59")), 13);
		TIME_RANGE.put(new TimeRange(toTime("18:00"), toTime("18:29")), 8);

	}

	public static int calculate(LocalTime localTime) {
		return TIME_RANGE.entrySet().stream()
				.filter(range -> localTime.isAfter(range.getKey().getStartTime().minusMinutes(1))
						&& localTime.isBefore(range.getKey().getEndTime().plusMinutes(1))).findFirst()
				.map(Entry::getValue).orElse(0);
	}

}
