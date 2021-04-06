<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body {
		text-align: center;
	}
	tr, th, td {
		border : 1px solid black;
	}
	table {
		margin-left: auto;
		margin-right: auto;
	}
</style>
<title>Feedbacks</title>
</head>
<body>

	<a href="/">Go back</a>
	<br/>
	<br/>
	<table>
		<tr>
			<th>Feedback ID</th>
			<th>Feedback</th>
			<th>Feedback From</th>
			<th>Feedback Date</th>
		</tr>
		<c:forEach var="feedback" items="${feedbacks}">
			<tr>
				<td>${feedback.id}</td>
				<td>${feedback.feedback}</td>
				<td>${feedback.from}</td>
				<td>${feedback.date}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>