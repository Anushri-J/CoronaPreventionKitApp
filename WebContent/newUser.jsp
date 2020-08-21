<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>Welcome to Corona Prevention Kit New User page</h1>
<h2> Please enter the details below </h2>
<form action="NewUserController" method="post" >

	<label> First name:</label>         
	<input type="text" name="first_name" size="15"/> <br> <br>  
	
	<label> Last Name:</label>         
	<input type="text" name="Last Name" size="15"/> <br> <br>  
	
	<label> Email id:</label>         
	<input type="text" name="Email_id" size="15"/> <br> <br> 
	
	<label> Address:</label>         
	<input type="text" name="Address" size="15"/> <br> <br>  
	
	<label> Contact no:</label>         
	<input type="text" name="Contact_no" size="15"/> <br> <br>  
	
<input type="submit" value="Submit" />
</form>
</body>
</html>