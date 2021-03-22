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
<title>Add a place</title>
</head>
<body>
	<form action="MasterPlaceServletAdd" method="post">
		<div class="form">
			<h3>Add a place to Master Place List!</h3>
			<input type="text" placeholder="Enter Place Name" name="placeName" required>
			<br/>
			<button type="submit">Add</button>
			<br/><br/>
		</div>
	</form>
</body>
</html>