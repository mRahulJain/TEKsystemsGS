package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.html");
		PrintWriter writer = response.getWriter();
		String email = ""; 
		Cookie cookieArray[] = request.getCookies();
		if(cookieArray!=null) {
			for(Cookie cookie : cookieArray) {
				email = cookie.getValue();
			}
		}
		writer.println("<h4 style= \"text-align: center; color: green;\"> Welcome to your profile "+email+" !</h4>");
		dispatcher.include(request, response);
	}
	
}
