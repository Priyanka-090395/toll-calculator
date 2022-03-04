package com.exam.tollfeecalculator.model;

import java.time.LocalTime;

public class TimeRange {

	private final LocalTime startTime;
	private final LocalTime endTime;

	/**
	 * Constructor to set the Time Range
	 *
	 */
	public TimeRange(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * 
	 * @return startTime from the Time Range
	 */
	public LocalTime getStartTime() {
		return startTime;
	}

	/**
	 * 
	 * @return endTime from the Time Range
	 */
	public LocalTime getEndTime() {
		return endTime;
	}

}
