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
<title>Register Yourself</title>
</head>
<body>

	<%
		if(request.getParameter("id")!=null) {
			request.getSession().setAttribute("flightID", request.getParameter("id"));
		}
		
		if(request.getParameter("count")!=null) {
			request.getSession().setAttribute("count", request.getParameter("count"));	
		}
		
		if(request.getParameter("isEco")!=null) {
			request.getSession().setAttribute("isEco", request.getParameter("isEco"));
		}
	
	%>
	<form action="RegisterServlet" method="post">
		<div class="form">
			<h3>You are few steps away!</h3>
			<input type="text" placeholder="Enter First Name" name="fname"
				required> <br /> <input type="text"
				placeholder="Enter Last Name" name="lname" required> <br />
			<input type="text" placeholder="Enter email" name="email" required>
			<br />
			<button type="submit">Register</button>
			<br />
			<br /> <span>Go <a href="SearchFlight.jsp">back?</a></span>
		</div>
	</form>
</body>
</html>