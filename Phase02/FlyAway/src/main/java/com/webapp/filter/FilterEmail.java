package com.webapp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEmail implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("email");
		PrintWriter writer = response.getWriter();
		
		String regex = "^[a-zA-Z0-9-.+_]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(email == null) {
			writer.println("<h4>Something went wrong!</h4>");
		}
		if(!matcher.matches()) {
			
			request.getRequestDispatcher("UserRegister.jsp").include(request, response);
			writer.println("<h4 style= \"text-align: center; color: red;\">The email you entered "+email+" is not a valid pattern!</h4>");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
