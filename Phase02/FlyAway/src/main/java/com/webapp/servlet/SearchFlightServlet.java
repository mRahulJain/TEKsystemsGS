package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;
import com.webapp.pojo.Flight;

public class SearchFlightServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String leavingFrom = request.getParameter("from");
		String arrivingAt = request.getParameter("to");
		String leavingOn = request.getParameter("date");
		String numberOfPersons = request.getParameter("personCount");
		String fareType = request.getParameter("class");

		PrintWriter writer = response.getWriter();
		AdminHibernateHelper helper = new AdminHibernateHelper();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		if (compareDates(leavingOn, sdf.format(date))) {
			
			if (helper.checkToAndFrom(leavingFrom, arrivingAt)) {
				List<Flight> availableFlights = helper.getFlightsBetween(leavingFrom, arrivingAt);
				
				if(availableFlights.isEmpty()) {
					// Either of place do not exist
					request.getRequestDispatcher("SearchFlight.jsp").include(request, response);
					writer.println("<BR/>");
					writer.println("<BR/>");
					writer.println("<h2 style=\"color: red;\">No flights available.</h2>");
				} else {
					if(fareType.equals("Economy")) {
						request.getRequestDispatcher("SearchFlight.jsp").include(request, response);
						writer.println("<BR/><BR/>");
						writer.println("<h2>Flights fetched for "+leavingOn+"</h2>");
						makeTable(availableFlights, writer, true, numberOfPersons);
					} else if(fareType.equals("Business")) {
						request.getRequestDispatcher("SearchFlight.jsp").include(request, response);
						writer.println("<BR/><BR/>");
						writer.println("<h2>Flights fetched for "+leavingOn+"</h2>");
						makeTable(availableFlights, writer, false, numberOfPersons);
					}
				}
				
			} else {
				// Either of place do not exist
				request.getRequestDispatcher("SearchFlight.jsp").include(request, response);
				writer.println("<BR/>");
				writer.println("<BR/>");
				writer.println("<h2 style=\"color: red;\">Either of the place don't have flight services.</h2>");
			}
		} else {
			// date added is less than current date
			request.getRequestDispatcher("SearchFlight.jsp").include(request, response);
			writer.println("<BR/>");
			writer.println("<BR/>");
			writer.println("<h2 style=\"color: red;\">Please enter date greater than or equal to the present date!</h2>");
		}
	}
	
	private static void makeTable(List<Flight> flights, PrintWriter writer, boolean flag, String persons) {
		writer.println("<BR/>");
		writer.println("<TABLE>");
		writer.println("<TR>");
		writer.println("<TH>Flight Airline</TH>");
		writer.println("<TH>Flight Name</TH>");
		writer.println("<TH>Flight From</TH>");
		writer.println("<TH>Flight Departure Time</TH>");
		writer.println("<TH>Flight To</TH>");
		writer.println("<TH>Flight Arrival Time</TH>");
		if(flag) {
			writer.println("<TH>Flight Fare (Economy)</TH>");
		} else {
			writer.println("<TH>Flight Fare (Business)</TH>");
		}
		writer.println("</TR>");
		for(Flight flight : flights) {
			writer.println("<TR>");
			writer.println("<TD>"+flight.getFlightAirline()+"</TD>");
			writer.println("<TD>"+flight.getFlightName()+"</TD>");
			writer.println("<TD>"+flight.getFlightFrom()+"</TD>");
			writer.println("<TD>"+flight.getScheduleDeparture()+"</TD>");
			writer.println("<TD>"+flight.getFlightTo()+"</TD>");
			writer.println("<TD>"+flight.getScheduleArrival()+"</TD>");
			int flightFare = 0;
			if(flag) {
				flightFare = Integer.parseInt(persons)*flight.getFlightFareEconomy();
			} else {
				flightFare = Integer.parseInt(persons)*flight.getFlightFareBusiness();
				
			}
			writer.println("<TD>Rs. "+flightFare+" (for "+persons+" person(s))</TD>");
			String href = "UserRegister.jsp?id="+flight.getId()+"&count="+Integer.parseInt(persons)+"&isEco="+flag;
			writer.println("<TD><a href="+href+">Book?</a></TD>");
			writer.println("</TR>");
		}
		
		writer.println("</TABLE>");
		writer.println("");
	}

	private static boolean compareDates(String d1, String d2) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);

			System.out.println("Date1" + sdf.format(date1));
			System.out.println("Date2" + sdf.format(date2));
			System.out.println();

			if (date1.after(date2)) {
				return true;
			}

			if (date1.before(date2)) {
				return false;
			}

			if (date1.equals(date2)) {
				return true;
			}

			System.out.println();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return false;
	}

}
