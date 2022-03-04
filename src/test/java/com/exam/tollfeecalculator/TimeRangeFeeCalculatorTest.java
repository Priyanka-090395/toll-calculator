package com.exam.tollfeecalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exam.tollfeecalculator.util.TollFeeDateUntil;

import static com.exam.tollfeecalculator.service.TimeRangeFeeCalculator.calculate;

public class TimeRangeFeeCalculatorTest {

	@Test
	public void testTimeRange() {
		assertEquals(8, calculate(TollFeeDateUntil.toTime("06:00")));
		assertEquals(18, calculate(TollFeeDateUntil.toTime("07:00")));
		assertEquals(13, calculate(TollFeeDateUntil.toTime("17:59")));
	}


}
