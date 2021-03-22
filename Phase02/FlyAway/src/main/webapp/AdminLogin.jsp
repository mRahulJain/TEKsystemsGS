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
<title>Admin Login</title>
</head>
<body>
	<form action="AdminLoginVerifyServlet" method="post">
		<div class="form">
			<h3>Hello Admin!</h3>
			<input type="text" placeholder="Enter Username" name="username" required>
			<br/>
			<input type="password" placeholder="Enter Password" name="password" required>
			<br/>
			<button type="submit">Login</button>
			<br/><br/>
			<span>Change <a href="ChangeAdminPassword.jsp">password?</a></span>
		</div>
	</form>
</body>
</html>