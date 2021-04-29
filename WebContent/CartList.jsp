<%@page import="com.app.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.app.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store - Cart List</title>

<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	
	$(document).ready(function(){
		
		var quantity = $(".quantity")
		var bookPrice = $(".bookprice")
		var totalbookpriceInput = $(".totalbookprice")
		var totalBookPrice;
		var totalAmount = 0
		
		
		$("input").focusout(function(){
			
			var totalAmount = 0
			
			
			for(var i = 0; i < quantity.length; i++){
				
				if(quantity[i].value <= 0){
					alert("Minimum Quantity Should Be 0 Or Remove From Cart!")
					quantity[i].value = 1
				}
				
				totalBookPrice = quantity[i].value * bookPrice[i].value
				
				totalAmount = totalAmount + totalBookPrice
				
				$(totalbookpriceInput[i]).val(totalBookPrice)
			}
			
			$("#totalprice").val(totalAmount)
			
		});
	})
	
	
</script>
</head>
<body>
<%@include file="Header.jsp" %>
<center>
	<form action="OrderServlet" method="post">
	<fieldset>
		<legend>Cart List</legend>
		<table border="1">
			<tr>
				<th>Cart Id</th>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Quantity</th>
				<th>Book Price</th>
				<th>Total Book Price</th>
				<th>Action</th>
			</tr>
			
			<%
				String email = (String) session.getAttribute("user");
				CartDao cartDao = new CartDao();
				List<Cart> carts =  cartDao.getCartByEmail(email);
				for(Cart c : carts){
				
			%>
				<tr>
					<td><%=c.getCartId() %></td>
					<td><%=c.getBookId() %></td>
					<td><%=c.getBookName() %></td>
					<td><input type="number" value="1" class="quantity" name="quantity"></td>
					<td><input type="number" class="bookprice" value="<%=c.getBookPrice() %>" readonly="readonly"></td>
					<td><input type="number" class="totalbookprice" readonly="readonly"></td>
					
					<td><a href="CartServlet?action=remove&id=<%=c.getCartId() %>">Remove From Cart</a></td>			
				</tr>
			
			<%		
				}
			%>
			
			<tr>
				<td colspan="6">Total Price:</td>
				<td colspan="1"><input type="number" name="totalAmount" id ="totalprice" readonly="readonly"></td>
				
				<!-- 
				<td colspan="1" id="totalprice" name="totalAmount"></td>
				 -->
				 
			</tr>
			
		</table>
			<br>
			<input type="submit" value="Place Order">
		
	</fieldset>
	</form>
</center>
<%@include file="Footer.jsp" %>
</body>
</html>