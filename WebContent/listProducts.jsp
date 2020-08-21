<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items List</title>
</head>
<body>
	<jsp:include page="adminPage.jsp" />
	<h4>Welcome to Admin Page</h4>
	<h3>Products Available</h3>
	
	<c:choose>
		<c:when test="${items==null || items.isEmpty() }">
			<p>No products Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Icode</th>
					<th>Title</th>
					<th>Unit</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${items}" var="item">
					<tr>
					<td>${item.icode }</td>
					<td>${item.title }</td>
					<td>${item.unit }</td>
					<td>${item.price }</td>
					<td>
						<a href="editProduct?icode=${item.icode }">EDIT</a> <span>|</span>				
						<a href="deleteProduct?icode=${item.icode }">DELETE</a> <span>|</span>
					</td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>