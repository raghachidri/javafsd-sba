<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div align="right">
<label><Strong>Welcome      </Strong></label><Strong><c:out value="${username}" /></Strong>
</div>
<div align="center">

        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Cost</th>
                <th>Product Description</th>
                <th>Action</th>
            </tr>
            <c:forEach var="prod" items="${corona}" >
                <tr>
                    <td><c:out value="${prod.id}" /></td>
                    <td><c:out value="${prod.productName}"  /></td>
                    <td><c:out value="${prod.cost}" /></td>
                    <td><c:out value="${prod.productDescription}" /></td>
                   
                   <td><a href="?action=Add?id=<c:out value='${prod.id}' />">Add</a>
                </tr>
            </c:forEach>
           
        </table>
        <div><c:out value="${message}"/></div>
         <div>
	<a href="?action=viewProduct"><button>view cart</button></a>
</div>
    </div>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>