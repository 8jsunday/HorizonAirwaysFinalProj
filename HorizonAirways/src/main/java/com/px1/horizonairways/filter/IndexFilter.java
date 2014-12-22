package com.px1.horizonairways.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.daimpl.FlightDetailsDAImpl;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.service.FlightDetailsService;


public class IndexFilter implements Filter {


	public IndexFilter() {
	
	}

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		FlightDetailsDA da = new FlightDetailsDAImpl();
		FlightDetailsService service = new FlightDetailsService(da);
		
		List<FlightSchedule> flightSchedule = service.getAllFlightSchedule();
		request.getServletContext().setAttribute("flightScheduleList", flightSchedule);
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
