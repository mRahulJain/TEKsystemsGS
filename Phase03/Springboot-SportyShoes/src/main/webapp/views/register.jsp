<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<title>Sporty Shoes | Register</title>
</head>
<body>

	<form action="home" method="post">
		<div class="form">
			<h3>Welcome to Sporty Shoes!</h3>
			<h5>Please register yourself to enjoy uninterrupted purchasing!</h5>
			<input type="text" placeholder="Enter Username" name="username" required>
			<br/>
			<input type="password" placeholder="Enter Password" name="password" required>
			<br/>
			<input type="text" placeholder="Enter First Name" name="firstName" required>
			<br/>
			<input type="text" placeholder="Enter Last Name" name="lastName" required>
			<br/>
			<input type="text" placeholder="Enter Email" name="email" required>
			<br/>
			<input type="number" placeholder="Enter Phone Number" name="phoneNumber" required>
			<br/>
			<input type="text" placeholder="Enter Address" name="address" required>
			<br/>
			<button type="submit">Register</button>
			<br/></br>
			OR
			<br/></br>
			<span>Already have an <a href="/login">account?</a></span>
		</div>
	</form>

</body>
</html>