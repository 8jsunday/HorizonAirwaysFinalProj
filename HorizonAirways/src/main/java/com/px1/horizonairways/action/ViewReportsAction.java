package com.px1.horizonairways.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.service.FlightDetailsService;

public class ViewReportsAction extends ActionSupport implements RequestAware {

	private Map<String, Object> request;

	public String execute() {
		
		FlightDetailsDA da = new FlightDetailsDAImpl();
		FlightDetailsService service = new FlightDetailsService(da);
		List<FlightDetails> flightDetailsList = service.getAllFlightDetails();
		request.put("flightDetailsList", flightDetailsList);
		
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

}
