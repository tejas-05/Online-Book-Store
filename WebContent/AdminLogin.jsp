<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="AdminHeader.jsp" %>
<form action="AdminLoginServlet" method="post">
		<center>
			<fieldset>
				<legend>Admin Login</legend>
				<table>
		<%
			String loginMsg = (String) session.getAttribute("loginMsg");
			if(loginMsg !=null){
		
		%>
			<h4 style="color:red"><%=loginMsg %></h4>
		<%	
			session.removeAttribute("loginMsg");
			}
		%>
					<tr>
						<td>Enter Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					
					<tr>
						<td>Enter Password</td>
						<td><input type="password" name="password"></td>
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