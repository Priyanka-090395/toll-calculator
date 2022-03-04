package com.exam.tollfeecalculator.model;

public enum VehicleType {

	CAR("Car"),
	MOTORBIKE("Motorbike"),
	TRACTOR("Tractor"),
	EMERGENCY("Emergency"),
	DIPLOMAT("Diplomat"),
	MILITARY("Military");

	private final String vehicleType;

	VehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
