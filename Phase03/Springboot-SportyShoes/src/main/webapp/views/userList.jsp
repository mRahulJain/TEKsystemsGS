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

input {
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
	<form id="right" action="/userList" method="get">
		<input type="submit" value="Show Complete List">
	</form>
	<form id="right" action="filteredUserList">
		<input type="text" placeholder="Type here..." name="like" required>
		<input type="submit" value="Search">
	</form>
	
	<span id="left">Go <a href="/adminPage">back?</a></span>
	<br>
	<br>
	<h2>Shoppers List</h2>
	<br>
	<br>
	<table>

		<tr>
			<th>Shopper ID</th>
			<th>Shopper Username</th>
			<th>Shopper First Name</th>
			<th>Shopper Last Name</th>
			<th>Shopper E-mail</th>
			<th>Shopper Phone Number</th>
			<th>Shopper Address</th>
		</tr>

		<c:forEach var="shopper" items="${shoppers}">

			<tr>
				<td>${shopper.id}</td>
				<td>${shopper.username}</td>
				<td>${shopper.firstName}</td>
				<td>${shopper.lastName}</td>
				<td>${shopper.email}</td>
				<td>${shopper.phoneNumber}</td>
				<td>${shopper.address}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>