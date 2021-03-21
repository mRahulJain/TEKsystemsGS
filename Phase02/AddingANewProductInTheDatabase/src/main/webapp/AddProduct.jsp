<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>
</head>
<body>

	<form action="" method="post">
		Enter Product Name : <input type="text" name="name"
			required="required"> <br />
		<br /> Enter Product Price : <input type="number" name="price"
			required="required"> <br />
		<br /> Enter Product Manufacturer Company : <input type="text"
			name="company" required="required"> <br />
		<br /> Enter Product Manufacturer Country : <input type="text"
			name="country" required="required"> <br />
		<br /> Is Product Available For Sale? <input type="radio"
			name="isAvailable" value=1 required="required"> <label
			for="Yes">Yes</label> <input type="radio" name="isAvailable"
			value=0 required="required"> <label for="No">No</label> <br />
		<br /> <input type="submit" value="Add Product" name="addProduct">
	</form>

	<br/><br/>

	<% if(request.getParameter("addProduct")!=null) {%>
		
		<jsp:useBean id="product" class="com.webapp.pojo.Product" scope="request"></jsp:useBean>
		<jsp:setProperty property="*" name="product"/>
		<jsp:forward page="ProductServlet"></jsp:forward>
	
	<%}%>

</body>
</html>