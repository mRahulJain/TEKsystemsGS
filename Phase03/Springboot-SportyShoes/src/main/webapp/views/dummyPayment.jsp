<!DOCTYPE html>
<%@page import="com.springboot.pojo.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
}
</style>
<title>Sporty Shoes | Payment</title>
</head>
<body>
	
	<c:url var="buyLink" value="completePayment">
		<c:param name="productId" value="${productId}" />
		<c:param name="shopperId" value="${shopperId}" />
		<c:param name="productQuantity" value="${productQuantity}" />
	</c:url>

	<form action="${buyLink}" method="post">
		<div class="form">
			<h3>You are at the last step<br>Complete the payment!</h3>
			<input type="number" placeholder="Enter Account Number" name="accountNumber" required>
			<br/>
			<input type="text" placeholder="Enter Account Holder Name" name="name" required>
			<br/>
			<input type="number" placeholder="Enter CVV Number" name="name" required>
			<br/>
			<input type="number" placeholder="Amount To Be Paid" name="amount" required value="${productQuantity*product.productPrice}" readonly="readonly">
			<br/>
			<button type="submit">Complete Payment</button>
		</div>
	</form>
</body>
</html>