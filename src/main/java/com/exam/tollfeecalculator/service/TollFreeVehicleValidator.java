package com.exam.tollfeecalculator.service;

import java.util.HashSet;
import java.util.Set;

import com.exam.tollfeecalculator.model.Vehicle;
import com.exam.tollfeecalculator.model.VehicleType;

public class TollFreeVehicleValidator {

  private static final Set<VehicleType> TOLL_FREE_VEHICLES = new HashSet<>();

	static {
		TOLL_FREE_VEHICLES.add(VehicleType.MOTORBIKE);
		TOLL_FREE_VEHICLES.add(VehicleType.TRACTOR);
		TOLL_FREE_VEHICLES.add(VehicleType.EMERGENCY);
		TOLL_FREE_VEHICLES.add(VehicleType.DIPLOMAT);
		TOLL_FREE_VEHICLES.add(VehicleType.MILITARY);
	}

	public static boolean isTollFreeVehicle(Vehicle vehicle) {
		return vehicle != null && TOLL_FREE_VEHICLES.contains(vehicle.getVehicleType());
	}
}
