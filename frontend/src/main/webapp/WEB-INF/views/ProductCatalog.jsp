<%@include file="Header.jsp"%>

<div class ="container">
<div class = "row">
<c:forEach items="${productList }" var="product">
		<div class = "col-md-4 col-xs-12 col-sm-6">
			<div class = "thumbnail">
			<h4>
			<span data-toggle ="tooltip" title="Bootstrap version">${product.productName} &nbsp;RS.${product.price }/-</span>
			</h4>
			<img src="<c:url value="/resources/images/${product.productID }.jpg"/>" class="img-thumbnail" height="100" width="100"/>
			<a href="<c:url value="/productDisplay/${product.productID }"/>"class = "btn btn-primary col-xs-12" role="button">Click for Large</a>
			<div class = "clearfix"></div>
			</div>
		</div>
</c:forEach>
</div>

</div>