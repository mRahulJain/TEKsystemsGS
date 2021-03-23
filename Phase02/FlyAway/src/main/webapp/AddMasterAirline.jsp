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
<title>Add an airline</title>
</head>
<body>
	<form action="MasterAirlineServletAdd" method="post">
		<div class="form">
			<h3>Add an airline to Master Airline List!</h3>
			<input type="text" placeholder="Enter Airline Name" name="airlineName" required>
			<br/>
			<button type="submit">Add</button>
			<br/><br/>
			<span>Go <a href="AdminFrontPage.jsp">back?</a></span>
		</div>
	</form>
</body>
</html>