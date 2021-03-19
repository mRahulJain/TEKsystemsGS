package com.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.java.Product;

public class ProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Product> productList = (List<Product>) session.getAttribute("productList");
		
		if(productList == null) {
			productList = new ArrayList<Product>();
			session.setAttribute("productList", productList);
		}
		
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productCompany = request.getParameter("productCompany");
		String productCountry = request.getParameter("productCountry");
		String productIsAvailable = request.getParameter("productAvailable");
		boolean productIsAvailableBoolean = false;
		if(productIsAvailable.equals("Yes")) {
			productIsAvailableBoolean = true;
		}
		
		productList.add(new Product(
				productName, 
				Integer.parseInt(productPrice), 
				productCompany, 
				productCountry, 
				productIsAvailableBoolean
			)
		);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductShow.jsp");
		dispatcher.forward(request, response);
	}

}
