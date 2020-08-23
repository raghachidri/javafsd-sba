<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="admin?action=updateproduct" method="post">

<c:if test="${prodList != null}">
					<input type="hidden" name="id" value="<c:out value='${prodList.id}' />" />
				</c:if>
				<label>Enter Product Name</label>
				 <input type="text" value="<c:out value='${prodList.productName}' />" 
						name="productName" required="required">
			

			<label for="cost">Enter cost</label> 
			<input type="number" value="<c:out value='${prodList.cost}' />" 
						name="cost" required="required">
		
		
			<label for="productDescription">Enter product description</label> 
			<input type="text" value="<c:out value='${prodList.productDescription}' />" 
						name="productDescription" required="required">
	
		<div>
			<div><input type="submit" value="updateproduct"> </div>
		</div>
<%-- Required View Template --%>
</form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>