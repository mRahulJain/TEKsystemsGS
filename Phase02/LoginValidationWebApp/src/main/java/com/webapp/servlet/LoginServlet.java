package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		req.getRequestDispatcher("Login.html").include(req, resp);
		if(password.equals("qwerty")) {
			writer.println("<h4 style= \"text-align: center; color: green;\"> You have successfully logged in!</h4>");
		} else {
			writer.println("<h4 style= \"text-align: center; color: red;\"> The password you entered is incorrect!</h4>");
		}
	}

}
