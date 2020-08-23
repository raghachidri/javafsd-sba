<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<form action="user?action=completeorder" method="post">
<div align="left">
        <table border="1" cellpadding="5" id="Table1">
            <caption><h2>Order Summary</h2></caption>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Cost</th>
                <th>Product Description</th>
               <th>Quantity</th>
                <th>ProdCost</th>

                
            </tr>
            <c:forEach var="prod" items="${prodList}">
                <tr>
                    <td><c:out value="${prod.id}" /></td>
                    <td><c:out value="${prod.productName}" /></td>
                    <td><c:out value="${prod.cost}" /></td>
                    <td><c:out value="${prod.productDescription}" /></td>
                    <td><c:out value="${prod.qty}" /></td>
                    <td><c:out value="${prod.pcost}" /></td>
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
    
 <div align="left">
 </hr>
 <div class="col-50">
<h3>Shipping Address</h3>
</div>

 <table border="0" cellpadding="5">
	<tr>
	<td><label><Strong>Full Name   </Strong></label></td>
    <td><Strong><c:out value="${username}" /></td>
	</tr>
	
	<tr>
	<td><label><Strong>Contact   </Strong></label></td>
    <td><Strong><c:out value="${phno}" /></td>
	</tr>
	
	<tr>
	<td><label><Strong>Email   </Strong></label></td>
    <td><Strong><c:out value="${email}" /></td>
	</tr>
	
	<tr>
	<td><label><Strong>Address   </Strong></label></td>
    <td><Strong><c:out value="${address}" /></td>
	</tr>
	
	<tr>
	<td><label><Strong>State   </Strong></label></td>
    <td><Strong><c:out value="${state}" /></td>
	</tr>
	
	<tr>
	<td><label><Strong>Zip   </Strong></label></td>
    <td><Strong><c:out value="${zip}" /></td>
	</tr>
	
</table>
 
 </div>   
 <div><input type="submit" value="Complete"> </div>
 
 </form>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>