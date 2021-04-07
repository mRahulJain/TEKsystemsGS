<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body {
		background-color: #5cdb95;
	}
	#admin {
		float: left;
		text-align: left;
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
<title>Sporty Shoes | Admin</title>
</head>
<body>
	<a href="/login" id="admin">Go Back</a>
	<form action="adminPage" method="post">
		<div class="form">
			<h1>Hello Admin!</h1>
			<h5>Please provide both the credentials to continue further</h5>
			<input type="text" placeholder="Enter Username" name="username" required>
			<br/>
			<input type="password" placeholder="Enter Password" name="password" required>
			<br/>
			<button type="submit">Login</button>
		</div>
	</form>

</body>
</html>