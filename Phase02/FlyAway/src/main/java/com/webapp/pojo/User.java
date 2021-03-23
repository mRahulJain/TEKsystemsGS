package com.webapp.pojo;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String ticketCount;
	private String isEco;
	private Flight flight;
	
	
	public String getIsEco() {
		return isEco;
	}
	public void setIsEco(String isEco) {
		this.isEco = isEco;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(String ticketCount) {
		this.ticketCount = ticketCount;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	public User(String firstName, String lastName, String email, String ticketCount, String isEco, Flight flight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ticketCount = ticketCount;
		this.isEco = isEco;
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", ticketCount="
				+ ticketCount + ", isEco=" + isEco + ", flight=" + flight + "]";
	}
	public User() {
		super();
	}

}
