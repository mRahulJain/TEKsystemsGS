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
<title>Admin Section</title>
</head>
<body>

	<div>
		<h1>Choose your option!</h1>
		<form action="MasterPlaceView" method="post">
			<button type="submit">View and Edit Place Master List</button>
		</form>
		<br/>
		<form action="MasterAirlineView" method="post">
			<button type="submit">View and Edit Airlines Master List</button>
		</form>
		<br/>
		<form action="MasterFlightView" method="post">
			<button type="submit">View and Edit Flights Master List</button>
		</form>
		<br/>
		<span><a href="SearchFlight.jsp">Logout?</a></span>
	</div>	

</body>
</html>