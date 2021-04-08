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
<title>Sporty Shoes | Admin</title>
</head>
<body>
	<form action="changeAdminPassword" method="post">
		<div class="form">
			<h3>Change your password here!</h3>
			<input type="password" placeholder="Enter Old Password" name="oldPassword" required>
			<br/>
			<input type="password" placeholder="Enter New Password" name="newPassword1" required>
			<br/>
			<input type="password" placeholder="Re-Enter New Password" name="newPassword2" required>
			<br/>
			<button type="submit">Change Password</button>
			<br/><br/>
			<span>Go <a href="/adminPage">back?</a></span>
		</div>
	</form>
</body>
</html>