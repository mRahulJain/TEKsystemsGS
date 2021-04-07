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
<title>Sporty Shoes | Checkout</title>
</head>
<body>

	<%
		Shopper shopper = (Shopper) request.getSession().getAttribute("shopper");
		Product product = (Product) request.getSession().getAttribute("product");
	%>
	
	<c:url var="buyLink" value="dummyPayment">
		<c:param name="productId" value="${product.id}" />
		<c:param name="shopperId" value="${shopper.id}" />
	</c:url>
	
	<form action="${buyLink}" method="post">
		<div class="form">
			<h3>Confirm your product details and select quantity</h3>
			<h5>Product Name - ${product.productName}</h5>
			<h5>Product Company - ${product.productCompany}</h5>
			<h5>Product Price - ${product.productPrice}</h5>
			<input type="number" min="1" name="quantity" value=1>
			<button type="submit">Continue</button>
		</div>
	</form>


</body>
</html>