package com.px1.horizonairways.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.da.PassengerReservationDA;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.daimpl.PassengerReservationDAImpl;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.service.FlightDetailsService;
import com.px1.horizonairways.service.PassengerReservationService;

public class PassengerSearchAction extends ActionSupport implements
		RequestAware {

	private String pnrNo, flightNo;
	private Map<String, Object> request;

	public String execute() {

		
		PassengerReservationDA  passengerDetailsDa = new PassengerReservationDAImpl();
		PassengerReservationService passengerDetailsService = new PassengerReservationService(passengerDetailsDa);

		Passenger passenger = passengerDetailsService.getPassengerDetailsByPNR(pnrNo);
		List<ReservedFlight> reservedFlights = passengerDetailsService.getAllReservedFlights(pnrNo);
		request.put("passenger", passenger);
		
		if (flightNo != null && reservedFlights.size() != 0) {

			passengerDetailsService.cancelReservation(pnrNo);
			
			FlightDetailsDA flightDetailsDA = new FlightDetailsDAImpl();
			FlightDetailsService flightDetailsService = new FlightDetailsService(flightDetailsDA);
			
			FlightId flightId = new FlightId(reservedFlights.get(0).getFlightNo(), reservedFlights.get(0).getFlightDate());
			FlightDetails firstFlight = flightDetailsService.getFlightDetailsById(flightId);
			Map<String, BigDecimal> flightFareMap = flightDetailsService.getFlightFareBySectorId(firstFlight.getSectorId());
			BigDecimal firstFlightFare = flightFareMap.get(reservedFlights.get(0).getSeatClass().trim());

			request.put("firstFlight", firstFlight);
			request.put("reservedFlight1", reservedFlights.get(0));
			request.put("firstFlightFare", firstFlightFare);

			if (reservedFlights.size() > 1) {
				BigDecimal secondFlightFare = flightFareMap.get(reservedFlights.get(1).getSeatClass().trim());
				request.put("secondFlightFare", secondFlightFare);
				flightId = new FlightId(reservedFlights.get(1).getFlightNo(),reservedFlights.get(1).getFlightDate());
				FlightDetails secondFlight = flightDetailsService.getFlightDetailsById(flightId);
				request.put("secondFlight", secondFlight);
				request.put("reservedFlight2", reservedFlights.get(1));

			}

			return "success";
		}

		else {

			request.put("reservedFlights", reservedFlights);
			return "search";

		}
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

}
