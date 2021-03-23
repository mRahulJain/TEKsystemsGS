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
<title>Add a flight</title>
</head>
<body>
	<form action="MasterFlightServletAdd" method="post">
		<div class="form">
			<h3>Add a flight to Master Flight List!</h3>
			<input type="text" placeholder="Enter Airline Name" name="flightAirline" required>
			<br/>
			<input type="text" placeholder="Enter Flight Name" name="flightName" required>
			<br/>
			<input type="text" placeholder="Enter Flight From" name="flightFrom" required>
			<br/>
			<input type="time" placeholder="Scheduled Departure Time" name="flightTimeDeparture" required>
			<br/>
			<input type="text" placeholder="Enter Flight To" name="flightTo" required>
			<br/>
			<input type="time" placeholder="Scheduled Arrival Time" name="flightTimeArrival" required>
			<br/>
			<input type="number" placeholder="Enter Economy Flight Fare" name="flightFareEconomy" required>
			<br/>
			<input type="number" placeholder="Enter Business Flight Fare" name="flightFareBusiness" required>
			<button type="submit">Add</button>
			<br/><br/>
			<span>Go <a href="AdminFrontPage.jsp">back?</a></span>
		</div>
	</form>
</body>
</html>