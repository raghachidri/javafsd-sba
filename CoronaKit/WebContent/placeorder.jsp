<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Place Order Form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div class="col-50">
<h3>Shipping Address</h3>
</div>

<form action="user?action=ordersummary" method="post">
<table border="0" cellpadding="5">
	<tr>
	<td><label><Strong>Full Name   </Strong></label></td>
    <td><input type="text" name="username" value="${username}" required/></td>
	</tr>
	
	<tr>
	<td><label><Strong>Contact   </Strong></label></td>
    <td><input type="text" name="contact" value="${phno}" required/></td>
	</tr>
	
	<tr>
	<td><label><Strong>Email   </Strong></label></td>
    <td><input type="email" name="email" value="${email}" required/></td>
	</tr>
	
	<tr>
	<td><label><Strong>Address   </Strong></label></td>
    <td><input type="text" name="address"  required/></td>
	</tr>
	
	<tr>
	<td><label><Strong>State   </Strong></label></td>
    <td><input type="text" name="state" required/></td>
	</tr>
	
	<tr>
	<td><label><Strong>Zip   </Strong></label></td>
    <td> <input type="text" name="zip" required/></td>
	</tr>
	
</table>
<div><input type="submit" value="Confirm Order"> </div>
</form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>