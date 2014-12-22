package com.px1.horizonairways.daimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import org.hibernate.Query;
import org.hibernate.Session;

import com.px1.horizonairways.da.LoginDA;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;

public class LoginDAImpl implements LoginDA {


	public LoginDAImpl() {

	}

	public User verifyLogin(Login login) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db-persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from user u where u.userName = ? AND u.password = ?");
		query.setParameter(0, login.getUserName());
		query.setParameter(1, login.getPassword());

		User user = ((User) query.uniqueResult());

		if ((user.getUserName().trim().equals(login.getUserName()))
				&& (user.getPassword().trim().equals(login.getPassword()))) {

			return user;
		} 
		else {
			
			return null;
		}
		
	}
}
