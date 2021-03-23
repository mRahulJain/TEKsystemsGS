package com.webapp.helper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.webapp.pojo.Admin;
import com.webapp.pojo.Airlines;
import com.webapp.pojo.Flight;
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
	
	public boolean checkPlace(String placeName) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Place> query = session.createQuery("from Place");
		List<Place> places = query.list();
		
		for(Place place: places) {
			if(place.getPlace().equals(placeName)) {
				return true;
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		return false;
	}
	
	public boolean checkToAndFrom(String placeName1, String placeName2) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Place> query = session.createQuery("from Place");
		List<Place> places = query.list();
		int flag = 0;
		for(Place place: places) {
			if(place.getPlace().equals(placeName1) || place.getPlace().equals(placeName2)) {
				flag++;
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		if(flag == 2)
			return true;
		return false;
	}
	
	public List<Airlines> getAirlines() {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Airlines> query = session.createQuery("from Airlines");
		List<Airlines> airlines = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return airlines;
	}
	
	public boolean addAirline(String airlineName) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Airlines> query = session.createQuery("from Airlines");
		List<Airlines> airlines = query.list();
		
		for(Airlines airline: airlines) {
			if(airline.getName().equals(airlineName)) {
				return false;
			}
		}
		
		Airlines airline = new Airlines(airlineName);
		session.save(airline);
		
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	
	public boolean checkAirline(String airlineName) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Airlines> query = session.createQuery("from Airlines");
		List<Airlines> airlines = query.list();
		
		for(Airlines airline: airlines) {
			if(airline.getName().equals(airlineName)) {
				return true;
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		return false;
	}
	
	public List<Flight> getFlights() {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Flight> query = session.createQuery("from Flight");
		List<Flight> flights = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return flights;
	}
	
	public Flight getFlightUsingID(int id) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Flight> query = session.createQuery("from Flight");
		List<Flight> flights = query.list();
		
		for(Flight flight :  flights) {
			if(flight.getId() == id) {
				return flight;
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		return null;
	}
	
	public boolean addFlight(Flight mFlight) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Flight> query = session.createQuery("from Flight");
		List<Flight> flights = query.list();
		
		for(Flight flight: flights) {
			if(flight.getFlightName().equals(mFlight.getFlightName())) {
				return false;
			}
		}
		
		session.save(mFlight);
		
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	public List<Flight> getFlightsBetween(String from, String to) {
		Session session = createSessionFactory().openSession();

		session.beginTransaction();

		Query<Flight> query = session.createQuery("from Flight");
		
		List<Flight> flights = new ArrayList<Flight>();
		for(Flight flight : query.list()) {
			if(flight.getFlightFrom().equals(from) && flight.getFlightTo().equals(to)) {
				flights.add(flight);
			}
		}
		
		session.getTransaction().commit();
		session.close();
		
		return flights;
	}
	
	private SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.webapp.pojo.Admin.class);
		configuration.addAnnotatedClass(com.webapp.pojo.Place.class);
		configuration.addAnnotatedClass(com.webapp.pojo.Airlines.class);
		configuration.addAnnotatedClass(com.webapp.pojo.Flight.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		return factory;
	}

}
