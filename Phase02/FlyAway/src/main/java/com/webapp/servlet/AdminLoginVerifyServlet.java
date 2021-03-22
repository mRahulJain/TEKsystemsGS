package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;

public class AdminLoginVerifyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher wrongDispatcher = request.getRequestDispatcher("AdminLogin.jsp");
		PrintWriter writer = response.getWriter();
		if(request.getParameter("username").equals("admin")) {
			if(request.getParameter("password").equals(new AdminHibernateHelper().getPassword())) {
				//success
				RequestDispatcher rightDiapatcher = request.getRequestDispatcher("AdminFrontPage.jsp");
				rightDiapatcher.forward(request, response);
			} else {
				//password failure
				wrongDispatcher.include(request, response);
				writer.println("<h3 style=\"color: red;\">Wrong password!<h3>");
			}
		} else {
			//username failure
			wrongDispatcher.include(request, response);
			writer.println("<h3 style=\"color: red;\">Wrong username!<h3>");
		}
	}

}
