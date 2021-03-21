<%@page import="com.webapp.hibernate.HibernateHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, com.webapp.pojo.*, com.webapp.hibernate.*"%>


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<title>View Products</title>
</head>
<body>


	<h3>Your products are -</h3>
	<table>

		<%
			new HibernateHelper().getProducts(request);
			List<Product> productList = (List<Product>) request.getAttribute("productList");
			if (productList == null || productList.size() == 0) {
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
				<td>${productItem.name}</td>
				<td>${productItem.price}</td>
				<td>${productItem.company}</td>
				<td>${productItem.country}</td>
				<c:choose>
					<c:when test="${productItem.isAvailable==1}">
						<td>Available</td>
					</c:when>
					<c:otherwise>
						<td>Not Available</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>


	</table>
	<br />
	<br />
	<form action="AddProduct.jsp" method="post">
		<input type="submit" value="Add More Products">
	</form>
</body>
</html>