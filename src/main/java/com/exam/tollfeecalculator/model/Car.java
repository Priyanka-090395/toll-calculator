package com.exam.tollfeecalculator.model;

import static com.exam.tollfeecalculator.model.VehicleType.CAR;

public class Car implements Vehicle {

	@Override
	public VehicleType getVehicleType() {
		return CAR;
	}

}
