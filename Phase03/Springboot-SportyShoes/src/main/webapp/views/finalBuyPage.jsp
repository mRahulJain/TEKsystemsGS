<%@page import="com.springboot.pojo.Product"%>
<%@page import="com.springboot.pojo.Shopper"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #5cdb95;
}
h3 {
	text-align: center;
}
.form {
	text-align: center;
	background-color: #edf5e1;
	margin: auto;
	width: 30%;
	padding: 20px;
}
input {
	margin: 8px;
	width: 80%;
	padding: 10px;
}
button {
	margin: 8px;
	width: 88%;
	padding: 10px;
}
</style>
<title>Sporty Shoes | Order Placed</title>
</head>
<body>

	<%
		int shopperId = (Integer) request.getSession().getAttribute("shopperId");
		Product product = (Product) request.getSession().getAttribute("product");
		int purchaseQuantity = (Integer) request.getSession().getAttribute("purchaseQuantity");
		double purchaseAmount = (Double) request.getSession().getAttribute("purchaseAmount");
	%>
	
	<c:url var="buyLink" value="/home/${shopperId}"/>

	<form action="${buyLink}" method="post">
		<div class="form">
			<h3>Order Placed</h3>
			<h5>Product Name - ${product.productName}</h5>
			<h5>Product Company - ${product.productCompany}</h5>
			<h5>Product Price - ${product.productPrice}</h5>
			<h5>Product Quantity - ${purchaseQuantity}</h5>
			<h5>Amount paid - ${purchaseAmount}</h5>
			<button type="submit">Shop More!</button>
		</div>
	</form>


</body>
</html>