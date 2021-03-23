<!DOCTYPE html>
<%@page import="com.webapp.helper.AdminHibernateHelper"%>
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
<title>Complete Payment</title>
</head>
<body>
	<form action="FinalPage.jsp" method="post">
		<div class="form">
			<h3>You are at the last step<br>Complete the payment!</h3>
			<input type="number" placeholder="Enter Account Number" name="accountNumber" required>
			<br/>
			<input type="text" placeholder="Enter Account Holder Name" name="name" required>
			<br/>
			<input type="number" placeholder="Enter CVV Number" name="name" required>
			<br/>
			<button type="submit">Complete Payment</button>
			<br/> <br/> <span>Go <a href="SearchFlight.jsp">back?</a></span>
		</div>
	</form>
</body>
</html>