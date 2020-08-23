<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h1>Visitor User Details</h1>
<form action="user?action=showproducts" method="post">
			<table style="with: 50%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" required/></td>
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="emailaddress" required/></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="tel" name="contact" pattern="[1-9]{9}[0-9]{1}" required></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>