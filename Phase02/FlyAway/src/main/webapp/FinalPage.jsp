<!DOCTYPE html>
<%@page import="com.webapp.pojo.User"%>
<%@page import="com.webapp.helper.AdminHibernateHelper"%>
<html>
<head>
<style type="text/css">
body {
	background-color: #5cdb95;
}

h2, h3 {
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

	<%
		User user = (User) request.getSession().getAttribute("user");
	%>
	
		<div class="form">
			<h2>Yayyyy!<br/>Flight booked</h2>
			<h5>Flight Airline - ${user.flight.flightAirline}</h5>
			<h5>Flight Name - ${user.flight.flightName}</h5>
			<h5>Flight From - ${user.flight.flightFrom}</h5>
			<h5>Flight Departure Time - ${user.flight.scheduleDeparture}</h5>
			<h5>Flight To - ${user.flight.flightTo}</h5>
			<h5>Flight Arrival Time - ${user.flight.scheduleArrival}</h5>
			<% if(user.getIsEco().equals("true")) { %>
				<h5>Flight Fare - ${user.flight.flightFareEconomy}</h5>
			<% } else { %>
				<h5>Flight Arrival Time - ${user.flight.flightFareBusiness}</h5>
			<% }%>
			<h5>Booking In Email - ${user.email}</h5>
			<h5>Booking In Name - ${user.firstName} ${user.lastName}</h5>
			<h5>Booking Ticket(s) Count - ${user.ticketCount}</h5>
			<br/> <br/> <span>Book <a href="SearchFlight.jsp">more?</a></span>
		</div>
</body>
</html>