<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Person</title>
</head>
<body>
	<a href="index.jsp">Go back</a>
	<br/>
	<br/>
	<form action="update" method="post">
		USER ID : <input type="number" name="userID" value="${person.id}" readonly="readonly"/>
		<br/>
		<br/>
		USER NAME : <input type="text" name="userName" value="${person.username}"/>
		<br/>
		<br/>
		USER EMAIL : <input type="text" name="userEmail" value="${person.email}"/>
		<br/>
		<br/>
		USER PASSWORD : <input type="text" name="userPassword" value="${person.password}"/>
		<br/>
		<br/>
		USER AGE : <input type="number" name="userAge" value="${person.age}"/>
		<br/>
		<br/>
		<input type="submit" value="UPDATE">
	</form>
	
	<c:if test="${type == true}">
		<h2 style="color: green;">Update Success!</h2>
	</c:if>

</body>
</html>