<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.app.pojo.Book"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store - Update Book</title>
</head>
<body>

<%@include file="Header.jsp" %>
<form action="BookServlet" method="post" enctype="multipart/form-data">
		<%
			Book book = (Book) request.getAttribute("book");
		%>
		<input type="hidden" name="action" value="update">
	
		<center>
			<fieldset>
				<legend>Update Book</legend>
				<table>
					<tr>
						<td>Book ID :</td>
						<td><input type="text" value="<%=book.getBookId() %>" name="bookid"></td>
					</tr>
					<tr>
						<td>Book Name :</td>
						<td><input type="text" value="<%=book.getBookName() %>" name="bookname"></td>
					</tr>
					<tr>
						<td>Book Category :</td>
						<td><input type="text" value="<%=book.getBookCategory() %>" name="bookcategory"></td>
					</tr>
					
					<tr>
						<td>Author Name :</td>
						<td><input type="text" value="<%=book.getAuthorName() %>" name="author"></td>
						</tr>
					<tr>
						<td>Rating :</td>
						<td><input type="text" value="<%=book.getRating() %>" name="rating"></td>
					</tr>
					<tr>
						<td>No_of_copies :</td>
						<td><input type="text" value="<%=book.getNoOfCopies() %>" name="noOfCopies"></td>
						</tr>
					<tr>
						<td>Book Image</td>
						<td><input type="file" name="bookimage" value="<%=book.getBookImage()%>"></td>
					</tr>	
					<tr>
						<td>Book price :</td>
						<td><input type="number" value="<%=book.getBookPrice() %>" name="bookprice"></td>
						</tr>
					<tr>
						<td><input type="submit" value="Update book"></td>
						<td><input type="reset" value="Reset"></td>
					</tr>
				</table>
			</fieldset>
		</center>
	</form>
	<%@include file="Footer.jsp" %>
</body>
</html>