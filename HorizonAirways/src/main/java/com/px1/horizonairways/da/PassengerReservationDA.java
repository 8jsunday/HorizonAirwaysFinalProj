package com.px1.horizonairways.da;

import java.util.List;

import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;

public interface PassengerReservationDA {

	public int savePassenger(Passenger p);

	public String getPassengerPNR(Passenger p);

	public int cancelPassengerReservation(String pnr);

	public Passenger getPassengerDetailsByPNR(String pnr);

	public List<Passenger> getAllPassengersByFlightId(FlightId id);

	public List<ReservedFlight> getReservedFlights(String pnr);

	public int saveFlightReservation(ReservedFlight reservedFlight);

}
