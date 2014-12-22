package com.px1.horizonairways.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.FlightAircraftDA;
import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.daimpl.FlightAircraftDAImpl;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.PassengerSeatPlan;
import com.px1.horizonairways.service.FlightAircraftService;
import com.px1.horizonairways.service.FlightDetailsService;

public class FlightDetailsCaptureAction extends ActionSupport implements
		SessionAware, RequestAware {

	private Map<String, Object> request;
	private Map<String, Object> session;
	private String firstFlightRadio;
	private String trip;
	private String secondFlightRadio;

	public String execute() {

		
		FlightDetailsDA  da = new FlightDetailsDAImpl();
		FlightDetailsService service = new FlightDetailsService(da);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = format.parse(firstFlightRadio);
			FlightId id = new FlightId(session.get("firstFlightNo").toString(),date);
			session.put("firstFlight", service.getFlightDetailsById(id));

			FlightAircraftDA flightAircraftDA = new FlightAircraftDAImpl();
			FlightAircraftService flightAircraftService = new FlightAircraftService(flightAircraftDA);
			PassengerSeatPlan firstPassengerSeatPlan = flightAircraftService.getPassengerSeatPlanByFlightId(id);
			request.put("firstPassengerSeatPlan", firstPassengerSeatPlan);
			request.put("flightId1", id);

			if (trip.equals("roundtrip")) {

				date = format.parse(secondFlightRadio);
				id = new FlightId(session.get("secondFlightNo").toString(),date);
				session.put("secondFlight", service.getFlightDetailsById(id));
				PassengerSeatPlan secondPassengerSeatPlan = flightAircraftService.getPassengerSeatPlanByFlightId(id);
				request.put("secondPassengerSeatPlan", secondPassengerSeatPlan);
				request.put("flightId2", id);
				
			} else {
				
				session.put("secondFlight", null);
				request.put("secondPassengerSeatPlan", null);
				request.put("flightId2", null);
			}

		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getFirstFlightRadio() {
		return firstFlightRadio;
	}

	public void setFirstFlightRadio(String firstFlightRadio) {
		this.firstFlightRadio = firstFlightRadio;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getSecondFlightRadio() {
		return secondFlightRadio;
	}

	public void setSecondFlightRadio(String secondFlightRadio) {
		this.secondFlightRadio = secondFlightRadio;
	}

}
