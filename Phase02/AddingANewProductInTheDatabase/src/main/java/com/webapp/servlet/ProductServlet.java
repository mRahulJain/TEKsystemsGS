package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.hibernate.HibernateHelper;
import com.webapp.pojo.Product;

public class ProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = (Product) request.getAttribute("product");
		HibernateHelper hibernateHelper = new HibernateHelper();
		hibernateHelper.addProduct(response, request, product);
	}
}
