<%
	String loggedUserName = (String) session.getAttribute("user");
	if(loggedUserName == null){
		response.sendRedirect("Login.jsp");
	}
%>


<%@page import="com.app.dao.BookDao"%>
<%@page import="com.app.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>

<%@include file="Header.jsp" %>
<form>
	<center>
		<fieldset>
			<legend>Book List</legend>
			<%
				String BookDeleteMsg = (String) request.getAttribute("BookDeleteMsg");
				if(BookDeleteMsg != null){
			%>
				<h3 style="color:red"><%=BookDeleteMsg %></h3>
			<%	
				request.removeAttribute("BookDeleteMsg");
				}
				
				String bookUpdateMsg = (String) request.getAttribute("bookUpdateMsg");
				if(bookUpdateMsg != null){
				
			%>
				<h3 style="color:red"><%=bookUpdateMsg %></h3>
			<%	
				request.removeAttribute("bookUpdateMsg");
				}
				
			%>
				<table border="1">
					<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Book Category</th>
					<th>Author Name</th>
					<th>Ratings</th>
					<th>No_of_Copies</th>
					<th>Book Price</th>
					<th>Book Image</th>
					
					<%
						String admin = (String) session.getAttribute("user");
						if(admin != null && admin.equals("admin")){

					%>
						
					<th>Update</th>
					<th>Delete</th>
					<%		
						}
						else{
					
					%>
						<th>Action</th>
					<%		
						}
					%>
					
					<%
						
						BookDao bookDao = new BookDao();
						List<Book> books = bookDao.getAllBooks();
						for(Book b: books){
									
					%>
					
					<tr>
						<td><%=b.getBookId() %></td>
						<td><%=b.getBookName() %></td>
						<td><%=b.getBookCategory() %></td>
						<td><%=b.getAuthorName() %></td>
						<td><%=b.getRating() %></td>
						<td><%=b.getNoOfCopies() %></td>
						<td><%=b.getBookPrice() %></td>
						<td><img src="ImageServlet?id=<%=b.getBookId()%>" style="height:100px"></td>
						
						<%
							//String admin = (String) session.getAttribute("admin");
							if(user != null && user.equals("admin")){
						%>
							
						<td><a href="BookServlet?action=update&id=<%=b.getBookId()%>">Update</a></td>
						<td><a href="BookServlet?action=delete&id=<%=b.getBookId()%>">Delete</a></td>		
						
						<%
								
							}
							else{
								
						%>
						
						<td><a href="CartServlet?action=addtocart&id=<%=b.getBookId()%>">Add To Cart</a></td>		
						
						<%		
							}
						%>
								
					</tr>
					
					<%		
						}
					%>
					
					</tr>
					
					<tr>
						
					</tr>
				</table>
		</fieldset>
	</center>
</form>
<%@include file="Footer.jsp" %>
</body>
</html>