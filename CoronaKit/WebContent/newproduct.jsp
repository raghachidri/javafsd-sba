<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<%-- Required View Template --%>


<form action="admin?action=insertproduct" method="post">
		
		<div>
			<div><label for="productName">Enter product Name</label> </div>
			<div><input type="text" id="productName" name="productName" required> </div>
		</div>
		<div>
			<div><label for="cost">Enter cost</label> </div>
			<div><input type="number" id="cost" name="cost" required> </div>
		</div>
		<div>
			<div><label for="productDescription">Enter product description</label> </div>
			<div><input type="text" id="productDescription" name="productDescription" required> </div>
		</div>
		<div>
			<div><input type="submit" value="insertproduct"> </div>
		</div>
	</form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>