package com.exam.tollfeecalculator.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.exam.tollfeecalculator.model.Vehicle;
import com.exam.tollfeecalculator.util.TollFeeUtil;

public class TollCalculator {

	private static final int MAXIMUM_TOTAL_FEE_PER_DAY = 60;

	public static int calculateTollFee(Vehicle vehicle, LocalDateTime... dates) {

		if (TollFeeUtil.isNotNull(vehicle) && TollFeeUtil.isArrayNotEmpty(dates) && isOnSameDay(dates)) {
			return calculateAllDatesFee(vehicle, dates);
		}
		// If any of the input values are null then return zero
		return 0;
	}

	private static int calculateAllDatesFee(Vehicle vehicle, LocalDateTime... dates) {
		LocalDateTime intervalStart = dates[0];
		final int feeFirstTrip = calculateFirst(vehicle, intervalStart);
		int totalFee = feeFirstTrip;
		List<LocalDateTime> remainingTrips = Arrays.asList(dates).subList(1, dates.length);

		if (totalFee > 0) {

			for (LocalDateTime date : remainingTrips) {
				int feeCurrentTrip = calculateFirst(vehicle, date);
				long minutesSinceFirstTrip = Duration.between(intervalStart, date).toMinutes();

				if (minutesSinceFirstTrip > 60) {
					// Add total/full fee
					totalFee = totalFee + feeCurrentTrip;
				} else if (feeFirstTrip < feeCurrentTrip) {
					totalFee = totalFee + Math.abs(feeCurrentTrip - feeFirstTrip);
				}
			}
		}
		// return 60 if total fee > 60 else return total fee
		return Math.min(totalFee, MAXIMUM_TOTAL_FEE_PER_DAY);

	}

	private static int calculateFirst(Vehicle vehicle, LocalDateTime date) {
		return TollFreeVehicleValidator.isTollFreeVehicle(vehicle)
				|| TollFreeDateValidator.isTollFreeDay(date.toLocalDate()) ? 0
				: TimeRangeFeeCalculator.calculate(date.toLocalTime());
	}

	public static boolean isOnSameDay(LocalDateTime... dates) {
		if (dates.length == 1)
			return true;

		LocalDate day = dates[0].toLocalDate();
		for (LocalDateTime date : dates) {
			if (TollFeeUtil.isNotNull(day) && !(day.isEqual(date.toLocalDate()))) {
				return false;
			}
		}
		return true;
	}
}
