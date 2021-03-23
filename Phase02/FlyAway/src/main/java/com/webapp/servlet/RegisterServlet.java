package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.helper.AdminHibernateHelper;
import com.webapp.pojo.Flight;
import com.webapp.pojo.User;

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		
		String flightID = request.getSession().getAttribute("flightID")+"";
		Flight flight = new AdminHibernateHelper().getFlightUsingID(Integer.parseInt(flightID));
		
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setFlight(flight);
		user.setIsEco(request.getSession().getAttribute("isEco")+"");
		user.setTicketCount(request.getSession().getAttribute("count")+"");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("FlightDetails.jsp").forward(request, response);
	}

}
