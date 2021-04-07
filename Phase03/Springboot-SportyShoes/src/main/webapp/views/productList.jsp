<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #edf5e1;
}

table, tr, th, td {
	margin: auto;
	font-size: 16px;
	padding: 4px;
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;
}

#left {
	float: left;
	text-align: left;
	font-size: 20px;
}

#right {
	float: right;
	text-align: right;
	font-size: 20px;
}

h2 {
	text-align: center;
}
</style>
<title>Sporty Shoes | Admin</title>
</head>
<body>

	<span id="left">Go <a href="/adminPage">back?</a></span>
	<span id="right">Add a <a href="/addProduct">Product?</a></span>
	<br>
	<br>
	<h2>Product List</h2>
	<br>
	<br>
	<table>

		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Image</th>
			<th>Product Company</th>
			<th>Product Is Available for Sale?</th>
			<th>Product Category</th>
			<th>Product Operation</th>
		</tr>

		<c:forEach var="product" items="${products}">

			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.productPrice}</td>
				<td>${product.productImage}</td>
				<td>${product.productCompany}</td>
				<td>${product.productAvailableForSale}</td>
				<td>${product.category}</td>
				<td>
					<a href="product/update/${product.id}">Update</a> | 
					<a href="product/delete/${product.id}"
					onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
				</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>