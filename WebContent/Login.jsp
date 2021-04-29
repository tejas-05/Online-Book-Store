<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store - Login</title>
</head>
<body>

<%@include file="Header.jsp" %>
	<form action="UserLoginServlet" method="post">
		<center>
			<fieldset>
				<legend>User Login</legend>
				<table>
				
				<%
					String loginMsg = (String) session.getAttribute("loginMsg");
					if(loginMsg != null){
				%>
					
					<h3 style="color:red"><%=loginMsg %></h3>
					
				<%	
					session.removeAttribute("loginMsg");
					}
				%>
				
					<tr>
						<td>Enter Username</td>
						<td><input type="email" name="useremail" required></td>
					</tr>
					
					<tr>
						<td>Enter Password</td>
						<td><input type="password" name="password" required></td>
					</tr>
					
					<tr>
						<td>New User ?</td>
						<td><a href="AddCustomer.jsp">Register Here</a></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Login"></td>
						<td><input type="reset" value="Reset"></td>
					</tr>
					
				</table>
			</fieldset>
		</center>
	</form>
	
<%@include file="Footer.jsp" %>
</body>
</html>