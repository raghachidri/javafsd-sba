<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<body>
<jsp:include page="header.jsp"/>
<hr/>
<div>
	<a href="index.jsp">Logout</a>
</div>

 <div align="center">
        <table border="1" cellpadding="5" id="Table1">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Cost</th>
                <th>Product Description</th>
                <th>check</th>
            </tr>
            <c:forEach var="prod" items="${corona}">
                <tr>
                    <td><c:out value="${prod.id}" /></td>
                    <td><c:out value="${prod.productName}" /></td>
                    <td><c:out value="${prod.cost}" /></td>
                    <td><c:out value="${prod.productDescription}" /></td>
                      <td><a href="?action=editproduct?id=<c:out value='${prod.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="?action=deleteproduct?id=<c:out value='${prod.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
       
    </div>
  	<Strong><c:out value="${msg}" /> </Strong>
	<div>
	 
	</div>
	
	<div>
	<a href="?action=newproduct"><button>Enter new product</button></a>
</div>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>