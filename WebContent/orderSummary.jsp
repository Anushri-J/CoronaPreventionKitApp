<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout page</title>
</head>
<body>
<body>
	<h3>Order Summary</h3>	
	<c:choose>
		<c:when test="${orderedItems==null || orderedItems.isEmpty() }">
			<p>No products Found</p>
		</c:when>
		<c:otherwise>
				<form action="finalOrderSummary" method="post" >
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Icode</th>
					<th>Title</th>
					<th>Unit</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${orderedItems}" var="orderedItem">
					<tr>
					<td>${orderedItem.item.icode } <input hidden="true" type="checkbox" checked name=${orderedItem.item.icode} /></td>
					<td>${orderedItem.item.title }</td>
					<td>${orderedItem.item.unit }</td>
					<td>${orderedItem.item.price }</td>
					<td>${orderedItem.quantity }<input hidden="true" type="number" value=${orderedItem.quantity } name=${orderedItem.item.icode}_quantity size="2" /></td>
					</tr>
				</c:forEach>
			</table>
			<h3> Total cost: Rs.${total}</h3>
			<h4>Enter address details below and click on Place Order</h4>
			<label> Address: </label>         
			<input type="text" name="Address" size="30"/> <br> <br> 
			<input type="submit" value="Place Order" />
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>
