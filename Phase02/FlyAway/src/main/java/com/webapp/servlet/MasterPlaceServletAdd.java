package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;

public class MasterPlaceServletAdd extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String placeName = request.getParameter("placeName");
		AdminHibernateHelper helper = new AdminHibernateHelper();
		
		if(helper.addPlace(placeName)) {
			RequestDispatcher rightDispatcher = request.getRequestDispatcher("MasterPlaceView");
			rightDispatcher.forward(request, response);
		} else {
			RequestDispatcher wrongDispatcher = request.getRequestDispatcher("AddMasterPlace.jsp");
			wrongDispatcher.include(request, response);
			PrintWriter writer = response.getWriter();
			writer.println("<h3 style=\"color: red;\">Place Already Exists!<h3>");
		}
	}

}
