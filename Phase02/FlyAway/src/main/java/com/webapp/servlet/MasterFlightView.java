package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;
import com.webapp.pojo.Flight;

public class MasterFlightView extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Flight> flights = new AdminHibernateHelper().getFlights();
		PrintWriter writer = response.getWriter();
		produceHeader(writer);
		
		writer.println("<span id=\"back\">Go <a href=\"AdminFrontPage.jsp\">back?</a></span>");
		writer.println("<span id=\"add\">Add a <a href=\"AddMasterFlight.jsp\">flight?</a></span>");
		writer.println("<br/>");
		writer.println("<br/>");
		writer.println("<h2>Master Flight list");
		writer.println("<br/>");
		writer.println("<br/>");
		writer.println("<TABLE>");
		writer.println("<TR>");
		writer.println("<TH>Flight Id</TH>");
		writer.println("<TH>Airlines Name</TH>");
		writer.println("<TH>Flight Name</TH>");
		writer.println("<TH>Flight From</TH>");
		writer.println("<TH>Flight Departure Time</TH>");
		writer.println("<TH>Flight To</TH>");
		writer.println("<TH>Flight Arrival Time</TH>");
		writer.println("<TH>Flight Fare Economy</TH>");
		writer.println("<TH>Flight Fare Business</TH>");
		writer.println("</TR>");
		
		for(Flight flight : flights) {
			writer.println("<TR>");
			writer.println("<TD>" + flight.getId() + "</TD>");
			writer.println("<TD>" + flight.getFlightAirline() + "</TD>");
			writer.println("<TD>" + flight.getFlightName() + "</TD>");
			writer.println("<TD>" + flight.getFlightFrom() + "</TD>");
			writer.println("<TD>" + flight.getScheduleDeparture() + "</TD>");
			writer.println("<TD>" + flight.getFlightTo() + "</TD>");
			writer.println("<TD>" + flight.getScheduleArrival() + "</TD>");
			writer.println("<TD>" + flight.getFlightFareEconomy() + "</TD>");
			writer.println("<TD>" + flight.getFlightFareBusiness() + "</TD>");
			writer.println("</TR>");
		}
		
		writer.println("</TABLE>");
		produceFooter(writer);
	}
	
	private static void produceFooter(PrintWriter writer) {
		writer.println("</BODY>");
		writer.println("</HTML>");
	}
	
	private static void produceHeader(PrintWriter writer) {
		writer.println("<!DOCTYPE html>");
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("<STYLE type=\"text/css\">");
		writer.println("BODY {");
		writer.println("background-color: #edf5e1;");
		writer.println("}");
		writer.println("TABLE, TR, TH, TD {");
		writer.println("margin: auto;");
		writer.println("font-size: 16px;");
		writer.println("padding: 4px;");
		writer.println("border: 1px solid black;");
		writer.println("border-collapse: collapse;");
		writer.println("}");
		writer.println("#add {");
		writer.println("float: right;");
		writer.println("text-align: right;");
		writer.println("font-size: 20px;");
		writer.println("}");
		writer.println("#back {");
		writer.println("float: left;");
		writer.println("text-align: left;");
		writer.println("font-size: 20px;");
		writer.println("}");
		writer.println("H2 {");
		writer.println("text-align: center;");
		writer.println("}");
		writer.println("</STYLE>");
		writer.println("<TITLE>");
		writer.println("Place Master");
		writer.println("</TITLE>");
		writer.println("</HEAD>");
		writer.println("<BODY>");
	}

}
