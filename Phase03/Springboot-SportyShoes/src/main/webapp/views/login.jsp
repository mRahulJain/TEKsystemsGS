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
		float: right;
		text-align: right;
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
<title>Sporty Shoes | Login</title>
</head>
<body>
	<a href="/adminLogin" id="admin">Admin Section</a>
	<form action="home" method="post">
		<div class="form">
			<h1>Welcome to Sporty Shoes!</h1>
			<h5>Please login to enjoy uninterrupted purchasing!</h5>
			<input type="text" placeholder="Enter Username" name="username" required>
			<br/>
			<input type="password" placeholder="Enter Password" name="password" required>
			<br/>
			<button type="submit">Login</button>
			<br/></br>
			OR
			<br/></br>
			<span>Don't have an <a href="/register">account?</a></span>
		</div>
	</form>

</body>
</html>