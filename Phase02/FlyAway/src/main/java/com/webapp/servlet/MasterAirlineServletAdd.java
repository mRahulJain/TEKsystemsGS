package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;

public class MasterAirlineServletAdd extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String airlineName = request.getParameter("airlineName");
		AdminHibernateHelper helper = new AdminHibernateHelper();
		
		if(helper.addAirline(airlineName)) {
			RequestDispatcher rightDispatcher = request.getRequestDispatcher("MasterAirlineView");
			rightDispatcher.forward(request, response);
		} else {
			RequestDispatcher wrongDispatcher = request.getRequestDispatcher("AddMasterAirline.jsp");
			wrongDispatcher.include(request, response);
			PrintWriter writer = response.getWriter();
			writer.println("<h3 style=\"color: red;\">Airline Already Exists!<h3>");
		}
	}

}
