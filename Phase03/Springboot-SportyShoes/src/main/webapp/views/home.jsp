<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body {
		background-color: #5cdb95;
	}
	h1 {
		text-align: center;
	}
	table, tr, th, td {
		margin: auto;
		font-size: 16px;
		padding: 4px;
		text-align: center;
		border: 1px solid black;
		border-collapse: collapse;
	}
	input {
		margin: 4px;
		padding: 10px;
	}
	span {
		float: right;
		text-align: right;
		font-size: 20px;
	}
</style>
<title>Sporty Shoes | Home</title>
</head>
<body>
	<span><a href="/login">Logout?</a></span>
	<h1>Welcome to Sporty Shoes</h1>
	
	<table>
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Image</th>
			<th>Product Company</th>
			<th>Product Category</th>
			<th>Product Operation</th>
		</tr>
		
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.productName}</td>
				<td>${product.productPrice}</td>
				<td>
					<img width="100" height="100" alt="Shoe" src="${product.productImage}">
				</td>
				<td>${product.productCompany}</td>
				<td>${product.category}</td>
				<td>
				
					<c:url var="buyLink" value="/product/buy">
						<c:param name="productId" value="${product.id}" />
						<c:param name="shopperId" value="${userId}" />
					</c:url>
					<form action="${buyLink}" method="post">
						<input type="submit" value="Buy">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>