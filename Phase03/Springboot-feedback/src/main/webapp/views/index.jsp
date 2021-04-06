<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Feedback</title>
</head>
<body style="text-align: center;">

	<h2>Enter your feedback here</h2>
	<form action="feedback" method="post">
		<input type="text" name="myFeedback" placeholder="Your Feedback">
		<br /> <br /> <input type="text" name="myFeedbackName"
			placeholder="Your Name"> <br /> <br /> <input type="submit"
			value="Add Feedback">
	</form>
	<hr>
	<form action="feedbacks" method="get">
		<input type="submit" value="Get All Feedbacks">
	</form>

</body>
</html>