<%@include file="Header.jsp"%>

<div class ="container">
	<table align = "center" class = "table">
		<tr>
			<td rowspan ="10">
				<img src="<c:url value="/resources/images/${productInfo.productID }.jpg"/>" height = "300" width ="200"/>
			</td>
		</tr>	
		<tr>
			<td>Product ID</td>
			<td>${productInfo.productID }</td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td>${productInfo.productName }</td>
		</tr>
		<tr>
			<td>Category</td>
			<td>${categoryName}</td>
		</tr>
		<tr>
			<td>Supplier Name</td>
			<td>${supplierName }</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${productInfo.price }</td>
		</tr>
		<tr>
			<td>Stock</td>
			<td>${productInfo.quantity }</td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td>${productInfo.productDesc }</td>
		</tr>
		<form action = "<c:url value="/addToCart/${productInfo.productID }"/>" method="get">
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add To Cart" class="btn btn-info"/></td>
			</tr>
		</form>
	</table>
</div>