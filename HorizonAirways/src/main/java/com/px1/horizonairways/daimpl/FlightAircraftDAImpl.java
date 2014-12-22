package com.px1.horizonairways.daimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;

import com.px1.horizonairways.da.FlightAircraftDA;
import com.px1.horizonairways.entity.AircraftLayout;
import com.px1.horizonairways.entity.FlightAircraftModel;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.util.SessionUtil;

public class FlightAircraftDAImpl implements FlightAircraftDA {
	public AircraftLayout getLayoutByFlightNo(String flightNo) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from flightaircraftmodel f where f.flightNo = ?");
		query.setParameter(0, flightNo);

		FlightAircraftModel flightAircraftModel = ((FlightAircraftModel) query.uniqueResult());
		AircraftLayout aircraftLayout = new AircraftLayout();
		String[] rows = flightAircraftModel.getRows().split(":");
		
		aircraftLayout.setFirstClassRows(new Integer(rows[0]));
		aircraftLayout.setBusinessClassRows(new Integer(rows[1]));
		aircraftLayout.setEconomyClassRows(new Integer(rows[2]));
		aircraftLayout.setFirstClassSeatArrangement(flightAircraftModel.getFirstClassArrangement());
		aircraftLayout.setBusinessClassSeatArrangement(flightAircraftModel.getBusinessClassArrangement());
		aircraftLayout.setEconomyClassSeatArrangement(flightAircraftModel.getEconomyClassArrangement());

		session.close();
		
		return aircraftLayout;

	}
	
	public List<String> getAllOccupiedSeatsByFlight(FlightId flightId) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from reservedFlight rf where rf.flightNo = ? AND rf.flightDate = ?");
		query.setParameter(0, flightId.getFlightNo());
		query.setDate(1, flightId.getFlightDate());
		List<ReservedFlight> reservedFlights = (List<ReservedFlight>) query.list();
		session.close();
		
		List<String> occupiedSeats = new ArrayList<String>();
		
		for (ReservedFlight reservedFlight : reservedFlights) {
			
			occupiedSeats.add(reservedFlight.getSeatNo());
		}

		return occupiedSeats;

	}

}
