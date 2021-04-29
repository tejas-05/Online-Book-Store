<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>

<center>
	<fieldset>
		<legend>Contact Us</legend>
		<table>
			<tr>
				<td>Enter Name:</td>
				<td><input type="text" required="required"></td>
			</tr>
			
			<tr>
				<td>Enter Contact Number:</td>
				<td><input type="number" required="required"></td>
			</tr>
	
			<tr>
				<td>Enter  Message:</td>
				<td><textarea rows="4" cols="22" ></textarea> </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</fieldset>
</center>

<%@include file="Footer.jsp" %>
</body>
</html>