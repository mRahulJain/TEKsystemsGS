package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.helper.AdminHibernateHelper;

public class ChangePasswordServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = new AdminHibernateHelper().getPassword();
		String enteredOldPassword = request.getParameter("oldPassword");
		String enteredNewPassword1 = request.getParameter("newPassword1");
		String enteredNewPassword2 = request.getParameter("newPassword2");
		
		PrintWriter writer = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ChangeAdminPassword.jsp");
		dispatcher.include(request, response);
		
		if(!oldPassword.equals(enteredOldPassword)) {
			writer.println("<h3 style=\"color: red;\">Wrong Old Password entered!<h3>");
			return;
		}
		
		if(!enteredNewPassword1.equals(enteredNewPassword2)) {
			writer.println("<h3 style=\"color: red;\">New Password's do not match!<h3>");
			return;
		}
		
		new AdminHibernateHelper().setPassword(enteredNewPassword1);
		writer.println("<h3 style=\"color: green;\">Password changed! You can go back!<h3>");
	}

}
