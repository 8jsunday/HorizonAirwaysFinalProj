package com.px1.horizonairways.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.PassengerReservationDA;
import com.px1.horizonairways.daimpl.PassengerReservationDAImpl;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.service.PassengerReservationService;

public class ReservationCompletionAction extends ActionSupport implements
		RequestAware {

	private String firstSeatNo, firstSeatClass, mealPreference, SSR,
			secondSeatNo, secondSeatClass;
	private Map<String, Object> request;

	public String execute() {

		PassengerReservationDA da = new PassengerReservationDAImpl();
		PassengerReservationService service = new PassengerReservationService(da);

		
		Passenger passenger = (Passenger) ActionContext.getContext().getSession().get("passenger");
		FlightDetails firstFlight = (FlightDetails) ActionContext.getContext().getSession().get("firstFlight");

		service.insertPassengerDetails(passenger);
		String pnr = service.getPassengerPNR(passenger);
		passenger.setPnr(pnr);

		ReservedFlight reservedFlight1 = new ReservedFlight(passenger, firstFlight.getFlightNo(), firstFlight.getFlightDate(), 
															firstSeatNo.toUpperCase(), firstSeatClass, mealPreference, SSR, 0);
		request.put("reservedFlight1", reservedFlight1);
		service.reservePassengerFlight(reservedFlight1);

		if (ActionContext.getContext().getSession().get("secondFlight") != null) {

			FlightDetails secondFlight = (FlightDetails) ActionContext.getContext().getSession().get("secondFlight");
			ReservedFlight reservedFlight2 = new ReservedFlight(passenger,secondFlight.getFlightNo(), secondFlight.getFlightDate(),
					secondSeatNo.toUpperCase(), secondSeatClass, mealPreference, SSR, 0);

			request.put("reservedFlight2", reservedFlight2);
			service.reservePassengerFlight(reservedFlight2);
		}

		return SUCCESS;
	}

	public String getFirstSeatNo() {
		return firstSeatNo;
	}

	public void setFirstSeatNo(String firstSeatNo) {
		this.firstSeatNo = firstSeatNo;
	}

	public String getFirstSeatClass() {
		return firstSeatClass;
	}

	public void setFirstSeatClass(String firstSeatClass) {
		this.firstSeatClass = firstSeatClass;
	}

	public String getMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(String mealPreference) {
		this.mealPreference = mealPreference;
	}

	public String getSSR() {
		return SSR;
	}

	public void setSSR(String sSR) {
		SSR = sSR;
	}

	public String getSecondSeatNo() {
		return secondSeatNo;
	}

	public void setSecondSeatNo(String secondSeatNo) {
		this.secondSeatNo = secondSeatNo;
	}

	public String getSecondSeatClass() {
		return secondSeatClass;
	}

	public void setSecondSeatClass(String secondSeatClass) {
		this.secondSeatClass = secondSeatClass;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

}
