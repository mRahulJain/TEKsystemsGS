<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Add A Product!</title>
</head>
<body>
	<form action="ProductServlet" method="post">
		Enter Product Name : <input type="text" name="productName" required="required"> <br/><br/>
		Enter Product Price : <input type="number" name="productPrice" required="required"> <br/><br/>
		Enter Product Manufacturer Company : <input type="text" name="productCompany" required="required"> <br/><br/>
		Enter Product Manufacturer Country : <input type="text" name="productCountry" required="required"> <br/><br/>
		Is Product Available For Sale? 
		<input type="radio" name="productAvailable" value="Yes" required="required">
		<label for="Yes">Yes</label>
		<input type="radio" name="productAvailable" value="No" required="required">
		<label for="No">No</label>
		<br/><br/>
		<input type="submit" value="Add Product">
	</form>
</body>
</html>