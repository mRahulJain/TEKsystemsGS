package com.webapp.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.webapp.pojo.Admin;
import com.webapp.pojo.Place;

public class AdminHibernateHelper {

	public String getPassword() {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Admin> query = session.createQuery("from Admin");
		Admin admin = query.list().get(0);

		session.getTransaction().commit();
		session.close();

		return admin.getPassword();
	}

	public String setPassword(String password) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Admin admin = session.get(Admin.class, 1);
		admin.setPassword(password);

		session.getTransaction().commit();
		session.close();

		return admin.getPassword();
	}

	public List<Place> getPlaces() {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Place> query = session.createQuery("from Place");
		List<Place> places = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return places;
	}
	
	public boolean addPlace(String placeName) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Place> query = session.createQuery("from Place");
		List<Place> places = query.list();
		
		for(Place place: places) {
			if(place.getPlace().equals(placeName)) {
				return false;
			}
		}
		
		Place place = new Place(placeName);
		session.save(place);
		
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	private SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.webapp.pojo.Admin.class);
		configuration.addAnnotatedClass(com.webapp.pojo.Place.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		return factory;
	}

}
