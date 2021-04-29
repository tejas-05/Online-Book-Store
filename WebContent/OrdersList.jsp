<%@page import="com.app.pojo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.app.dao.OrderDao"%>
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
			<legend>Order List</legend>
			<table border="1">
				<tr>
				<th>Order id</th>
				<th>Username</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Total Price</th>
				<th>Action</th>
				</tr>

				<%
					OrderDao od = new OrderDao();
					List<Order> orders = od.getAllOrders();
					for(Order o : orders){
				
				%>
				<tr>
					<td><%=o.getOrderId()%></td>
					<td><%=o.getCustEmail()%></td>
					<td><%=o.getOrderStatus()%></td>
					<td><%=o.getOrderDate()%></td>
					<td><%=o.getTotalPrice()%></td>
					
					<td><a href="OrderServlet?action=proceed&orderid=<%=o.getOrderId()%>">Proceed</a> | <a href="OrderServlet?action=cencel&orderid=<%=o.getOrderId() %>">Cancel</a></td>
					
				</tr>

				<%		
					}
				%>
				
			</table>
		</fieldset>
	</center>
	<%@include file="Footer.jsp" %>
</body>
</html>