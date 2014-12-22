package com.px1.horizonairways.daimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.px1.horizonairways.da.PassengerReservationDA;
import com.px1.horizonairways.entity.FlightId;
import com.px1.horizonairways.entity.Passenger;
import com.px1.horizonairways.entity.ReservedFlight;
import com.px1.horizonairways.util.SessionUtil;

public class PassengerReservationDAImpl implements PassengerReservationDA {

	public int savePassenger(Passenger p) {

		int rows = 1;
		EntityTransaction transaction = null;
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(p);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}
			rows = 0;
		}

		return rows;

	}

	public String getPassengerPNR(Passenger p) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from passenger p where p.firstName = ? and p.lastName = ? and p.birthDay = ? and p.reservationDate = ? ");
		query.setParameter(0, p.getFirstName());
		query.setParameter(1, p.getLastName());
		query.setDate(2, p.getBirthDay());
		query.setDate(3, p.getReservationDate());
		
		Passenger passenger = (Passenger) query.uniqueResult();
		session.close();

		return passenger.getPnr();

	}

	public int cancelPassengerReservation(String pnr) {

		int rows = 1;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = null;
		Query query = session.createQuery("from reservedFlight rf where rf.passenger.pnr = ?");
		query.setParameter(0, pnr);
		
		ReservedFlight reservedFlight = (ReservedFlight) query.uniqueResult();

		try {
			transaction = session.beginTransaction();
			reservedFlight.setCancelFlag(1);
			session.update(reservedFlight);
			transaction.commit();

		} catch (Exception ex) {

			if (transaction != null) {
				rows = 0;
				transaction.rollback();
			}
		}
		
		finally {
			
			session.close();
		}
		
		return rows;
	}

	public Passenger getPassengerDetailsByPNR(String pnr) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from passenger p where p.pnr = ? ");
		query.setParameter(0, pnr);
		Passenger passenger = (Passenger) query.uniqueResult();
		session.close();
		return passenger;

	}

	public List<Passenger> getAllPassengersByFlightId(FlightId id) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from reservedFlight rf where rf.flightNo = ? and rf.flightDate = ?");
		query.setParameter(0, id.getFlightNo());
		query.setDate(1, id.getFlightDate());
		List<ReservedFlight> reservedFlights = (List<ReservedFlight>) query.list();
		session.close();

		List<Passenger> passengers = new ArrayList<Passenger>();
		
		for (ReservedFlight reservedFlight : reservedFlights) {
			
			if (reservedFlight.getCancelFlag() != 1) {
				
				passengers.add(reservedFlight.getPassenger());
			}
		}

		return passengers;

	}

	public List<ReservedFlight> getReservedFlights(String pnr) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from reservedFlight rf where rf.passenger.pnr = ? and rf.cancelFlag = '0'");
		query.setParameter(0, pnr);

		List<ReservedFlight> reservedFlights = (List<ReservedFlight>) query.list();
		session.close();
		return reservedFlights;

	}

	public int saveFlightReservation(ReservedFlight reservedFlight) {

		int rows = 1;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(reservedFlight);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}
			rows = 0;
		}

		return rows;

	}


}
