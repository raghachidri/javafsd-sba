<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div align="right">
<label><Strong>Welcome      </Strong></label><Strong><c:out value="${username}" /></Strong>
</div>
<form action="user?action=placeorder" method="post">
<div align="center">
        <table border="1" cellpadding="5" id="Table1">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Cost</th>
                <th>Product Description</th>
               <th>Quantity</th>
                <th>ProdCost</th>
                <th>Action</th>

                
            </tr>
            <c:forEach var="prod" items="${prodList}">
                <tr>
                    <td><c:out value="${prod.id}" /></td>
                    <td><c:out value="${prod.productName}" /></td>
                    <td><c:out value="${prod.cost}" /></td>
                    <td><c:out value="${prod.productDescription}" /></td>
                    <td><c:out value="${prod.qty}" /></td>
                    <td><c:out value="${prod.pcost}" /></td>
                     <td><a href="?action=deleteitem?id=<c:out value='${prod.id}' />">Remove from cart</a>
                </tr>                
            </c:forEach>
            
            <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>Total Quantity & Total Price</td>
             <td> <c:out value="${TotalQty}" /></td>
      		<td> <c:out value="${TotalCost}" /></td>
      		</tr>
        </table>
          
    </div>
    <input type="submit" value="Place Order"/>
  </form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>