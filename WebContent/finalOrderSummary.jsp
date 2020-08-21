<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout page</title>
</head>
<body>
<body>
	<h3>Final Order Summary</h3>
	<c:choose>
		<c:when test="${orderedItems==null || orderedItems.isEmpty() }">
			<p>No products Found</p>
		</c:when>
		<c:otherwise>
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
					<td>${orderedItem.item.icode }</td>
					<td>${orderedItem.item.title }</td>
					<td>${orderedItem.item.unit }</td>
					<td>${orderedItem.item.price }</td>
					<td>${orderedItem.quantity }</td>
					</tr>
				</c:forEach>
			</table>
			<h3> Total cost: Rs.${total}</h3>
			<h4>Order will be shipped to address: ${Address}</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>
