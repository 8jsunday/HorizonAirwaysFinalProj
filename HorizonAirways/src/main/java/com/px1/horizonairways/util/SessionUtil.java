package com.px1.horizonairways.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class SessionUtil {

	public static Session getSession() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		return session;

	}
	
}
