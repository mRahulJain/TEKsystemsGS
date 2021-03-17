package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.jdbc.internal.OracleResultSet;
import oracle.jdbc.internal.OracleStatement;

public class SearchServlet extends HttpServlet {
	
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		getHeader(writer);
		getFooter(writer);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		if(!sid.equals("")) {
			performPost(sid, response);
		}
		
	}
	
	private static void performPost(String sid, HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(sid);
		PrintWriter writer = response.getWriter();
		getHeader(writer);
		try {
			Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rahul");
			String query = "SELECT * FROM product where productId=?";
			OraclePreparedStatement stmt = (OraclePreparedStatement) con.prepareStatement(query);
			stmt.setInt(1, id);
			OracleResultSet rs = (OracleResultSet) stmt.executeQuery();
			int countItem = 0;
			writer.println("<BR/>");
			writer.println("<BR/>");
			writer.println("<TABLE>");
			writer.println("<TR>");
			writer.println("<TH>ProductId</TH>");
			writer.println("<TH>ProductName</TH>");
			writer.println("<TH>ProductManufacturingDate</TH>");
			writer.println("<TH>ProductExpiryDate</TH>");
			writer.println("<TH>ProductManufacturedBy</TH>");
			writer.println("</TR>");
			while(rs.next()) {
				countItem++;
				writer.println("<TR>");
				writer.println("<TD>"+rs.getString(1)+"</TD>");
				writer.println("<TD>"+rs.getString(2)+"</TD>");
				writer.println("<TD>"+rs.getString(3)+"</TD>");
				writer.println("<TD>"+rs.getString(4)+"</TD>");
				writer.println("<TD>"+rs.getString(5)+"</TD>");
				writer.println("</TR>");
			}
			writer.println("</TABLE>");
			
			if(countItem == 0) {
				writer.println("<BR/>");
				writer.println("<BR/>");
				writer.println("<h3 class=\"error\">No records found with the id "+ id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getFooter(writer);
	}
	
	private static void getHeader(PrintWriter writer) {
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("<TITLE>Product Database</TITLE>");
		includeCSS(writer);
		writer.println("</HEAD>");
		writer.println("<BODY>");
		writer.println("<DIV style=\"text-align: center;\">");
		writer.println("<H1>Welcome to the product database</H1>");
		writer.println("<H3>Search a product by typing productID</H3>");
		writer.println("<FORM method=\"post\">");
		writer.println("Product Id : <input type=\"text\" name=\"id\"");
		writer.println("<BR/>");
		writer.println("<input type=\"submit\" value=\"SEARCH\">");
		writer.println("<BR/>");
	}
	
	private static void getFooter(PrintWriter writer) {
		writer.println("</DIV>");
		writer.println("</BODY>");
		writer.println("</HTML>");
	}
	
	private static void includeCSS(PrintWriter writer) {
		writer.println("<STYLE>");
		writer.println(".error {");
		writer.println("color: red;");
		writer.println("}");
		writer.println("TABLE {");
		writer.println("margin-left: auto;");
		writer.println("margin-right: auto;");
		writer.println("border: 1px solid black;");
		writer.println("border-collapse: collapse;");
		writer.println("}");
		writer.println("TH, TD, TR {");
		writer.println("padding: 5px 5px 5px 5px;");
		writer.println("text-align: center;");
		writer.println("border: 1px solid black;");
		writer.println("border-collapse: collapse;");
		writer.println("}");
		writer.println("</STYLE>");
	}
	
}
