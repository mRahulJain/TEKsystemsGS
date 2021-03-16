package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("email", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		PrintWriter writer = response.getWriter();
		writer.println("<h4 style= \"text-align: center; color: green;\">You successfully logged out!</h4>");
		request.getRequestDispatcher("Login.html").include(request, response);
	}

}
