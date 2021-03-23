package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;
import com.webapp.pojo.Flight;

public class MasterFlightServletAdd extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightAirline = request.getParameter("flightAirline");
		String flightName = request.getParameter("flightName");
		String flightFrom = request.getParameter("flightFrom");
		String flightTimeDeparture = request.getParameter("flightTimeDeparture");
		String flightTo = request.getParameter("flightTo");
		String flightTimeArrival = request.getParameter("flightTimeArrival");
		String flightFareEconomy = request.getParameter("flightFareEconomy");
		String flightFareBusiness = request.getParameter("flightFareBusiness");
		
		AdminHibernateHelper helper = new AdminHibernateHelper();
		RequestDispatcher wrongDispatcher = request.getRequestDispatcher("AddMasterFlight.jsp");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		if(helper.checkAirline(flightAirline)) {
			
			if(helper.checkPlace(flightFrom) && helper.checkPlace(flightTo)) {
				Flight mFlight = new Flight(
						flightName,
						flightFrom,
						flightTimeDeparture,
						flightTo,
						flightTimeArrival,
						flightAirline,
						Integer.parseInt(flightFareEconomy),
						Integer.parseInt(flightFareBusiness)
				);
				if(helper.addFlight(mFlight)) {
					RequestDispatcher rightDispatcher = request.getRequestDispatcher("MasterFlightView");
					rightDispatcher.forward(request, response);
				} else {
					writer.println("<h3 style=\"color: red;\">Flight already exists!<h3>");
					wrongDispatcher.include(request, response);
				}
				
			} else {
				writer.println("<h3 style=\"color: red;\">One or both the place(s) mentioned do not exist. Please add them first!<h3>");
				wrongDispatcher.include(request, response);
			}
			
		} else {
			writer.println("<h3 style=\"color: red;\">Airline do not exist. Please add it first!<h3>");
			wrongDispatcher.include(request, response);
		}
	}

}
