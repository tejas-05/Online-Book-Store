<%@page import="com.app.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.app.dao.CustomerDao"%>
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
		<legend>My Profile</legend>
		
		<table border="1">
			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Customer Email</th>
				<th>Customer Password</th>
				<th>Customer Contact</th>
				<th>Customer City</th>
				<th>Update Details</th>
			</tr>
			
			<%
				String email = (String) session.getAttribute("user");
				if(email != null){
					CustomerDao cDao = new CustomerDao();
					Customer c = cDao.getCustomerByEmail(email);	
					
			%>
				
			<tr>
				<td><%=c.getCustId() %></td>
				<td><%=c.getCustName() %></td>
				<td><%=c.getCustEmail() %></td>
				<td><%=c.getCustPassword() %></td>
				<td><%=c.getCustContact() %></td>
				<td><%=c.getCustAddress() %></td>
				<td><a href="#">Update</a></td>
			</tr>
			<%		
				}else{
					response.sendRedirect("Login.jsp");
				}
			%>
			
			
			
		</table>
	</fieldset>
</center>

	<%@include file="Footer.jsp" %>
</body>
</html>