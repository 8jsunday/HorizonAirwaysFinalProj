package com.px1.horizonairways.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.PassengerReservationDA;
import com.px1.horizonairways.daimpl.PassengerReservationDAImpl;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.service.PassengerReservationService;
import com.px1.horizonairways.util.DateUtil;

public class PassengerManifestAction extends ActionSupport implements RequestAware {

	private String flightNo, flightDate;
	private Map<String, Object> request;

	public String execute() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fDate = null;
		try {
			fDate = format.parse(flightDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		request.put("flightNo", flightNo);
		request.put("flightDate", DateUtil.formatDate(fDate));
		FlightId id = new FlightId(flightNo, fDate);
		
		PassengerReservationDA da = new PassengerReservationDAImpl();
		PassengerReservationService service = new PassengerReservationService(da);
		List<Passenger> passengerList = service.getAllPassengersByFlight(id);
		
		request.put("passengerList", passengerList);

		return SUCCESS;

	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

}
