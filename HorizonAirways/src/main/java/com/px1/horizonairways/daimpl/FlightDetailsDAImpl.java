package com.px1.horizonairways.daimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.px1.horizonairways.da.FlightDetailsDA;
import com.px1.horizonairways.entity.FlightDetails;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.FlightSchedule;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.entity.Sector;
import com.px1.horizonairways.util.SessionUtil;

public class FlightDetailsDAImpl implements FlightDetailsDA {

	public List<FlightDetails> getAllFlightDetails() {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from flightDetails");
		List<FlightDetails> flightDetailsList = query.list();
		session.close();
		return flightDetailsList;

	}

	public FlightDetails getFlightDetails(FlightId flightId) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from flightDetails fd where fd.flightNo = ? AND fd.flightDate = ?");
		query.setParameter(0, flightId.getFlightNo());
		query.setParameter(1, flightId.getFlightDate());
		FlightDetails flightDetails = (FlightDetails) query.uniqueResult();
		session.close();
		
		return flightDetails;

	}

	public List<FlightSchedule> getAllFlightSchedule() {

		List<FlightSchedule> flightScheduleList = new ArrayList<FlightSchedule>();

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from flightschedule");
		flightScheduleList = query.list();
		session.close();
		
		return flightScheduleList;

	}

	public List<FlightDetails> getAllFlightDetailsByFlightNoAndDate(
			String flightNo, Date flightDate) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from flightDetails fd where fd.flightNo = ? AND fd.flightDate >= ?");
		query.setParameter(0, flightNo);
		query.setParameter(1, flightDate);
		List<FlightDetails> flightDetailsList = (List<FlightDetails>) query.list();
		session.close();
		
		return flightDetailsList;

	}

	public Map<String, BigDecimal> getFlightFareBySector(String sectorId) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from sector s where s.id = ?");
		query.setParameter(0, sectorId);
		Sector sector = (Sector) query.uniqueResult();
		
		Map<String, BigDecimal> flightFareMap = new HashMap<String, BigDecimal>();
		flightFareMap.put("First", sector.getFirstClassFare());
		flightFareMap.put("Business", sector.getBusinessClassFare());
		flightFareMap.put("Economy", sector.getEconomyClassFare());

		return flightFareMap;

	}

	public List<FlightDetails> getAllFlightDetailsBySector(String sector,
			Date date) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from flightDetails f where f.sectorId = ? AND f.flightDate > ?");
		query.setParameter(0, sector);
		query.setDate(1, date);
		List<FlightDetails> flightDetailsListBySector = query.list();

		return flightDetailsListBySector;

	}

	

}
