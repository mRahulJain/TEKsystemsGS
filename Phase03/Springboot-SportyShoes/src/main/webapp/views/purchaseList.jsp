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

input, select {
	margin: 4px;
	padding: 5px;
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

	<div id="right">
		<form id="right" action="filteredPurchaseListDate" method="get">
			<input type="date" name="date" placeholder="(DD-MM-YYYY)" required="required">
			<input type="submit" value="Filter">
		</form>
		<br/>
		<form id="right" action="filteredPurchaseListCategory">
			<select
				name="productCategory" id="class">
				<option value="Select">Select Category</option>
				<option value="Crocs">Crocs</option>
				<option value="Sandals">Sandals</option>
				<option value="Boots">Boots</option>
				<option value="Sneakers">Sneakers</option>
				<option value="Slippers">Slippers</option>
				<option value="Flip-Flops">Flip-Flops</option>
			</select>
			<input type="submit" value="Filter">
		</form>
		<br/>
		<form id="right" action="purchaseList" method="get">
			<input type="submit" value="Clear Filter">
		</form>
	</div>
	
	<span id="left">Go <a href="/adminPage">back?</a></span>
	<br>
	<br>
	<h2>Purchase List</h2>
	<br>
	<br>
	<table>

		<tr>
			<th>Purchase ID</th>
			<th>Shopper ID</th>
			<th>Product ID</th>
			<th>Product Category</th>
			<th>Purchase Date</th>
			<th>Purchase Quantity</th>
			<th>Purchase Amount</th>
		</tr>

		<c:forEach var="purchase" items="${purchases}">

			<tr>
				<td>${purchase.id}</td>
				<td>${purchase.purchaseshopperId}</td>
				<td>${purchase.purchaseproductId}</td>
				<td>${purchase.category}</td>
				<td>${purchase.purchaseDate}</td>
				<td>${purchase.purchaseQuantity}</td>
				<td>${purchase.purchaseAmount}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>