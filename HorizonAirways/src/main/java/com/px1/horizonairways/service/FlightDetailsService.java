package com.px1.horizonairways.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;

public class FlightDetailsService {

	private FlightDetailsDA da;

	public FlightDetailsService() {

	}

	public FlightDetailsService(FlightDetailsDA da) {
		this.da = da;
	}

	public void setDa(FlightDetailsDA da) {
		this.da = da;
	}

	public List<FlightSchedule> getAllFlightSchedule() {
		return da.getAllFlightSchedule();
	}

	public List<FlightDetails> getAllFlightDetailsBySector(String sectorId, Date d) {
		return da.getAllFlightDetailsBySector(sectorId, d);
	}

	public Map<String, BigDecimal> getFlightFareBySectorId(String sectorId) {
		return da.getFlightFareBySector(sectorId);
	}

	public FlightDetails getFlightDetailsById(FlightId id) {
		return da.getFlightDetails(id);
	}


	public List<FlightDetails> getAllFlightDetails() {
		return da.getAllFlightDetails();
	}

	public List<FlightDetails> getAllFlightDetailsByNumAndDate(String flightNo, Date date) {
		return da.getAllFlightDetailsByFlightNoAndDate(flightNo, date);
	}

}
