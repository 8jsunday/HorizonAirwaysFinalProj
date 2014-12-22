package com.px1.horizonairways.service;

import java.util.List;

import com.px1.horizonairways.da.PassengerReservationDA;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;

public class PassengerReservationService {

	private PassengerReservationDA da;

	public PassengerReservationService() {

	}

	public PassengerReservationService(PassengerReservationDA da) {
		this.da = da;
	}

	public void setDa(PassengerReservationDA da) {
		this.da = da;
	}

	public int insertPassengerDetails(Passenger passenger) {
		return da.savePassenger(passenger);
	}

	public String getPassengerPNR(Passenger passenger) {
		return da.getPassengerPNR(passenger);
	}

	public int cancelReservation(String pnr) {
		return da.cancelPassengerReservation(pnr);
	}

	public Passenger getPassengerDetailsByPNR(String pnr) {
		return da.getPassengerDetailsByPNR(pnr);

	}

	public List<Passenger> getAllPassengersByFlight(FlightId id) {
		return da.getAllPassengersByFlightId(id);
	}

	public List<ReservedFlight> getAllReservedFlights(String pnr) {
		return da.getReservedFlights(pnr);
	}

	public int reservePassengerFlight(ReservedFlight reservedFlight) {
		return da.saveFlightReservation(reservedFlight);
	}

}
