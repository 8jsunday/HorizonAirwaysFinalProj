package com.px1.horizonairways.action;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.service.FlightDetailsService;

public class FindFlightsAction extends ActionSupport implements SessionAware {

	private String flightNo;
	private String sectorId;
	private Map<String, Object> session;

	public String execute() {

		FlightDetailsDA da = new FlightDetailsDAImpl();
		FlightDetailsService service = new FlightDetailsService(da);
		
		Map<String, BigDecimal> flightFareMap = service.getFlightFareBySectorId(sectorId);
		session.put("flightFareMap", flightFareMap);

		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 30);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();

		List<FlightDetails> flightDetailsList = service.getAllFlightDetailsByNumAndDate(flightNo, date);

		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();

		String roundtripSector = sectorId.substring(3) + sectorId.charAt(2) + sectorId.substring(0, 2);
		List<FlightDetails> flightDetailsRoundtrip = service.getAllFlightDetailsBySector(roundtripSector, date);

		session.put("flightDetailsList", flightDetailsList);
		session.put("flightDetailsRoundtrip", flightDetailsRoundtrip);

		session.put("firstFlightNo", flightDetailsList.get(0).getFlightNo());
		session.put("secondFlightNo", flightDetailsRoundtrip.get(0).getFlightNo());

		return SUCCESS;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
