package com.exam.tollfeecalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exam.tollfeecalculator.model.Car;

import static com.exam.tollfeecalculator.service.TollFreeVehicleValidator.isTollFreeVehicle;

public class TollFreeVehicleValidatorTest {

	@Test
	public void testIsTollFreeVehicle() {
		assertFalse(isTollFreeVehicle(new Car()));
		assertFalse(isTollFreeVehicle(null));
	}

}
