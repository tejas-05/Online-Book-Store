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

<form action="CustomerServlet" method="post">
		<center>
			<fieldset style="width:70%;">
				<legend>Add Customer</legend>
				<table>
				<%
					String customerAddMsg = (String) request.getAttribute("customerAddMsg");
					if(customerAddMsg != null){
				%>
					<h3 style="color:red"><%=customerAddMsg %></h3>
				<%		
					request.removeAttribute("customerAddMsg");
					}
				%>
					<tr>
						<td>Customer Name :</td>
						<td><input type="text" name="customerName" required></td>
					</tr>
					<tr>
						<td>Customer Email :</td>
						<td><input type="email" name="email" required></td>
					</tr>
					<tr>
						<td>Customer Password :</td>
						<td><input type="password" id="password" name="password" required></td>
					</tr>
					<tr>
						<td>Customer Contact :</td>
						<td><input type="text" name="customerContact" required></td>
					</tr>
					<tr>
						<td>Customer Address :</td>
						<td><input type="text" name="customerAddress" required></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add Customer"></td>
						<td><input type="reset" value="Reset"></td>
					</tr>
				</table>
			</fieldset>
		</center>
	</form><br>
<%@include file="Footer.jsp" %>
</body>
</html>