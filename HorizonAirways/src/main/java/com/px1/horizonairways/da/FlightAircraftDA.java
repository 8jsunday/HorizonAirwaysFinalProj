package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.AircraftLayout;
import com.px1.horizonairways.entity.FlightId;

public interface FlightAircraftDA {

	AircraftLayout getLayoutByFlightNo(String flightNo);
	
	public List<String> getAllOccupiedSeatsByFlight(FlightId flightId);
}
