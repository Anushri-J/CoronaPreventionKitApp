<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items List</title>
</head>
<body>
	<h3>Products Available</h3>
	<h4>Select the products you want to buy, enter the quantity and click on Add to Cart</h4>
	
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No products Found</p>
		</c:when>
		<c:otherwise>
		<form action="Checkout" method="post" >
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Action</th>
					<th>Icode</th>
					<th>Title</th>
					<th>Unit</th>
					<th>Price</th>
					<th>Quantity</th>
					
				</tr>
				<c:forEach items="${items }" var="item">
					<tr>
					<td><input type="checkbox" name=${item.icode} /> </td> 
					<td>${item.icode }</td> 
					<td>${item.title }</td>
					<td>${item.unit }</td>
					<td>${item.price }</td>
					<td><input type="number" name=${item.icode}_quantity size="2" /></td>
				</tr>				
				</c:forEach>			
			</table>
			<br/>
				<br/>	
			<input type="submit" value="Add to Cart" />
			</form>
		</c:otherwise>		
	</c:choose>
</body>
</html>