package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(password.equals("qwerty")) {
			Cookie cookieEmail = new Cookie("email", email);
			response.addCookie(cookieEmail);
			request.getRequestDispatcher("Main.html").forward(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			request.getRequestDispatcher("Login.html").include(request, response);
			writer.println("<h4 style= \"text-align: center; color: red;\"> The password you entered is incorrect!</h4>");
		}
	}

}
