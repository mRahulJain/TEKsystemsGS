<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, com.webapp.java.*" %>
<%@ page errorPage="errorPage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table, tr, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
<title>View Products!</title>
</head>
<body>

	
	<h3>Your products added are - </h3>
	<table>
	
		<%	
			List<Product> productList = (List<Product>) session.getAttribute("productList");
			if(productList == null || productList.size() == 0) {
				response.sendError(1, "No products added yet!");
			}
		%>
	
	
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Manufacturing Company</th>
			<th>Product Manufavturing Country</th>
			<th>Product Is Available</th>
		</tr>
		
		<c:forEach var="productItem" items="${productList}">
			<tr>
				<td>${productItem.productName}</td>
				<td>${productItem.productPrice}</td>
				<td>${productItem.productCompany}</td>
				<td>${productItem.productCountry}</td>
				<c:if test="${productItem.productAvailable}">
					<td>Available</td>
				</c:if>
				<c:if test="${not productItem.productAvailable}">
					<td>Not Available</td>
				</c:if>
			</tr>
		</c:forEach>
	
	
	</table>
	<br/>
	<br/>
	<br/>
	<form action="ProductAdd.jsp" method="post">
		<input type="submit" value="Add More Products">
	</form>
</body>
</html>