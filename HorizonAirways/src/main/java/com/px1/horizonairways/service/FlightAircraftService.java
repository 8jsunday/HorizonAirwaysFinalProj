package com.px1.horizonairways.service;

import java.util.List;

import com.px1.horizonairways.da.FlightAircraftDA;
import com.px1.horizonairways.daimpl.FlightAircraftDAImpl;
import com.px1.horizonairways.entity.AircraftLayout;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.PassengerSeatPlan;

public class FlightAircraftService {
	FlightAircraftDA da;

	public FlightAircraftService(FlightAircraftDA da) {
		this.da = da;
	}

	public FlightAircraftService() {
	}

	public void setDa(FlightAircraftDAImpl da) {
		this.da = da;
	}

	public AircraftLayout getAircraftLayout(String flightNo) {
		return da.getLayoutByFlightNo(flightNo);
	}

	public List<String> getAllOccupiedSeatsByFlight(FlightId flightId) {
		return da.getAllOccupiedSeatsByFlight(flightId);
	}

	public PassengerSeatPlan getPassengerSeatPlanByFlightId(FlightId flightId) {
		PassengerSeatPlan seatPlan = new PassengerSeatPlan(flightId);
		return seatPlan;
	}

}
