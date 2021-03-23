<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body {
		background-color: #5cdb95;
	}
	#admin {
		float: right;
		text-align: right;
	}
	input[type="text"], input[type="number"], select, button {
		margin: 8px;
		padding: 10px;
	}
	input[type="date"] {
		margin: 8px;
		padding: 7.5px;
	}
	div {
		text-align: left;
		background-color: #edf5e1;
		margin: auto;
		width: 83%;
		padding: 20px;
	}
	h1, h2 {
		color: #05386b;
		text-align: center;
	}
	table, th, tr, td {
		margin: auto;
		font-size: 16px;
		padding: 4px;
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
<title>Search Flight</title>
</head>
<body>

	<a href="AdminLogin.jsp" id="admin">Admin Login</a>
	<br/></br>
	<h1>WELCOME TO FLY-AWAY!</h1>
	<br/></br>
	<div>
		<h2>SEARCH A FLIGHT</h2>
		<form action="SearchFlightServlet" method="post">
		<input type="text" name="from" placeholder="LeavingFrom" required="required">
		<input type="text" name="to" placeholder="ArrivingAt" required="required">
		<input type="date" name="date" placeholder="LeavingOn(DD-MM-YYYY)" required="required">
		<input type="number" name="personCount" placeholder="NumberOfPerson(s)" required="required">
		<select name="class" id="class">
			<option value="Select">Select Class</option>
			<option value="Economy">Economy</option>
			<option value="Business">Business</option>
		</select>
		<button type="submit">Search</button>
	</form>
	</div>
	
</body>
</html>