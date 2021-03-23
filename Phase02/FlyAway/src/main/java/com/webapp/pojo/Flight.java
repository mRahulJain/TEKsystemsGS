package com.webapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FLIGHT_ID")
	private int id;
	
	@Column(name="FLIGHT_NAME", nullable = false, unique = true)
	private String flightName;
	
	@Column(name="FLIGHT_DEPARTURE", nullable = false)
	private String scheduleDeparture;
	
	@Column(name="FLIGHT_FROM", nullable = false)
	private String flightFrom;
	
	@Column(name="FLIGHT_TO", nullable = false)
	private String flightTo;
	
	@Column(name="FLIGHT_ARRIVAL", nullable = false)
	private String scheduleArrival;
	
	@Column(name="FLIGHT_AIRLINE", nullable = false)
	private String flightAirline;
	
	@Column(name="FLIGHT_FARE_ECONOMY", nullable = false)
	private int flightFareEconomy;
	
	@Column(name="FLIGHT_FARE_BUSINESS", nullable = false)
	private int flightFareBusiness;
	
	public String getScheduleDeparture() {
		return scheduleDeparture;
	}

	public void setScheduleDeparture(String scheduleDeparture) {
		this.scheduleDeparture = scheduleDeparture;
	}

	public String getScheduleArrival() {
		return scheduleArrival;
	}

	public void setScheduleArrival(String scheduleArrival) {
		this.scheduleArrival = scheduleArrival;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightFrom() {
		return flightFrom;
	}

	public void setFlightFrom(String flightFrom) {
		this.flightFrom = flightFrom;
	}

	public String getFlightTo() {
		return flightTo;
	}

	public void setFlightTo(String flightTo) {
		this.flightTo = flightTo;
	}

	public String getFlightAirline() {
		return flightAirline;
	}

	public void setFlightAirline(String flightAirline) {
		this.flightAirline = flightAirline;
	}

	
	public Flight() {
		super();
	}

	public int getFlightFareEconomy() {
		return flightFareEconomy;
	}

	public void setFlightFareEconomy(int flightFareEconomy) {
		this.flightFareEconomy = flightFareEconomy;
	}

	public int getFlightFareBusiness() {
		return flightFareBusiness;
	}

	public void setFlightFareBusiness(int flightFareBusiness) {
		this.flightFareBusiness = flightFareBusiness;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", scheduleDeparture=" + scheduleDeparture
				+ ", flightFrom=" + flightFrom + ", flightTo=" + flightTo + ", scheduleArrival=" + scheduleArrival
				+ ", flightAirline=" + flightAirline + ", flightFareEconomy=" + flightFareEconomy
				+ ", flightFareBusiness=" + flightFareBusiness + "]";
	}

	public Flight(String flightName, String flightFrom, String scheduleDeparture, String flightTo,
			String scheduleArrival, String flightAirline, int flightFareEconomy, int flightFareBusiness) {
		super();
		this.flightName = flightName;
		this.scheduleDeparture = scheduleDeparture;
		this.flightFrom = flightFrom;
		this.flightTo = flightTo;
		this.scheduleArrival = scheduleArrival;
		this.flightAirline = flightAirline;
		this.flightFareEconomy = flightFareEconomy;
		this.flightFareBusiness = flightFareBusiness;
	}
	
	
}
