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

select {
	margin: 8px;
	width: 87%;
	padding: 10px;
}

button {
	margin: 8px;
	width: 88%;
	padding: 10px;
}
#left {
	float: left;
	text-align: left;
}
</style>
<title>Add Product | Admin</title>
</head>
<body>

	<span id="left">Go <a href="/productList">back?</a></span>
	<form action="productAdd" method="post">
		<div class="form">
			<h3>Hello Admin!</h3>
			<h5>Add your product here</h5>
			<input type="text" placeholder="Enter Product Name"
				name="productName" required>
			<br />
			<input type="text"
				placeholder="Enter Product Price" name="productPrice" required>
			<br />
			<input type="text" placeholder="Enter First Image URL"
				name="productImage" required>
			<br />
			<input type="text"
				placeholder="Enter Product Company" name="productCompany" required>
			<br />
			<input type="number"
				placeholder="Enter Is Product Available (0/1)" min="0" max="1"
				name="productIsAvailable" required>
			<br />
			<select
				name="productCategory" id="class">
				<option value="Select">Select Category</option>
				<option value="Crocs">Crocs</option>
				<option value="Sandals">Sandals</option>
				<option value="Boots">Boots</option>
				<option value="Sneakers">Sneakers</option>
				<option value="Slippers">Slippers</option>
				<option value="Flip-Flops">Flip-Flops</option>
			</select>
			<br/>
			<button type="submit">Add Product</button>
		</div>
	</form>

</body>
</html>