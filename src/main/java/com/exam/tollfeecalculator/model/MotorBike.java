package com.exam.tollfeecalculator.model;

import static com.exam.tollfeecalculator.model.VehicleType.MOTORBIKE;

public class MotorBike implements Vehicle{

	@Override
	public VehicleType getVehicleType() {
		return MOTORBIKE;
	}
	
	

}
