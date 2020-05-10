<%@include file="Header.jsp"%>
<html>
<body>
<h2><center>Welcome to Category Page!</center></h2>
<form action="addCategory" method="post">

	<div class="container">    
        <div id="categoryform" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title" align="center"><b>Category Detail</div>

                    </div>
                    
                    <div style="padding-top:30px" class="panel-body" >

                        
                        <form id="categoryform" class="form-horizontal" role="form">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon">Category Name</span>
                                        <input id="categoryname" type="text" class="form-control" name="categoryName" value="" placeholder="" required>
                                                                           
                            </div>
                            
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon">Category Desc</span>
                                        <input id="categorydesc" type="text" class="form-control" name="categoryDesc" value="" placeholder="" required>
                                                                           
                            </div>
                            
                            <div style="margin-top:10px" class="form-group" align="center">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <input type="submit" class="btn btn-success" value="Submit">
                                      <input type="reset" class="btn btn-success" value="Reset">
                                    </div>
                                </div>
</form>
</div>
</div>
</div>
</div>
</form>
<div class="container">
<table align="center" class="table table-dark table-striped" class="table table-bordered">
	<tr>
		<td colspan = "5"><center>Category Detail</center></td>
	</tr>
	</tr>
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Edit</td>
		<td>Delete</td>
	</tr>
	<c:forEach items="${categoryList }" var = "category">
		<tr>
		
			<td>${category.categoryID }</td>
			<td>${category.categoryName }</td>
			<td>${category.categoryDesc }</td>
			<td><a href="<c:url value="/editCategory/${category.categoryID}"/>" class="glyphicon glyphicon-pencil"></a></td>
			<td><a href="<c:url value="/deleteCategory/${category.categoryID}" />" class="glyphicon glyphicon-trash"></a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>
