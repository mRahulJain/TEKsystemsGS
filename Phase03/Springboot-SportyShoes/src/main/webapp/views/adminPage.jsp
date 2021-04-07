<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body {
		background-color: #5cdb95;
	}
	div {
		text-align: center;
		background-color: #edf5e1;
		margin: auto;
		width: 30%;
		padding: 20px;
	}
	button {
		margin: 4px;
		width: 88%;
		padding: 10px;
	}
}
</style>
<title>Sporty Shoes | Admin</title>
</head>
<body>

	<div>
		<h1>Choose your option!</h1>
		<form action="productList" method="get">
			<button type="submit">View and Edit Products List</button>
		</form>
		<br/>
		<form action="userList" method="get">
			<button type="submit">Track Registered Users</button>
		</form>
		<br/>
		<form action="purchaseList" method="get">
			<button type="submit">View Purchase Reports</button>
		</form>
		<br/>
		<span><a href="login">Logout?</a></span>
	</div>

</body>
</html>