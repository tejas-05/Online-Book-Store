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
	<form action="BookServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="add">
		<center>
			<fieldset>
				<legend>Add Book</legend>
				<table>
				<%
					String msg = (String) request.getAttribute("bookAddMsg");
					if(msg != null){
				%>
				<h3 style="color:red"><%=msg %></h3>
				
				<%		
					request.removeAttribute("bookAddMsg");	
					}
				%>
				
					<tr>
						<td>Add Book</td>
						<td><input type="text" name="bookname"></td>
					</tr>
					<tr>
						<td>Book Category :</td>
						<td><input type="text" name="bookcategory"></td>
					</tr>
					<tr>
						<td>Author Name :</td>
						<td><input type="text" name="authorname"></td>
						</tr>
					<tr>
						<td>Book Image :</td>
						<td><input type="file" name="bookimage"></td>
					</tr>
					<tr>
						<td>Rating :</td>
						<td><input type="text" name="rating"></td>
					</tr>
					<tr>
						<td>Quantity :</td>
						<td><input type="number" name="noOfCopies"></td>
					</tr>
					<tr>
						<td>Book price :</td>
						<td><input type="number" min="1" name="bookprice"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add book"></td>
						<td><input type="reset" value="Reset"></td>
					</tr>
					
				</table>
			</fieldset>
		</center>
	</form>
	<%@include file="Footer.jsp" %>
</body>
</html>