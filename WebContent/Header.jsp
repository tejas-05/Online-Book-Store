<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
	<div id="templatemo_menu">
		<%
			String user = (String) session.getAttribute("user");
			
			
		
			if(user != null && user.equals("admin")){
		
		%>
		
		<ul>
    		<li><a href="AddBook.jsp">Add Book</a></li>
    		<li><a href="BookList.jsp">Book List</a></li>
    		<li><a href="CustomerList.jsp">Customer List</a></li>
    		<li><a href="OrdersList.jsp">Orders List</a></li>
    		<li><a href="ContactUs.jsp">Contact Us</a></li>
    		<li style="float:right"><a href="Logout.jsp">Logout</a></li>
    		<li style="float:right"><a href="#">Welcome Admin</a></li>
		</ul>
		
		<%		
			}
			else if(user != null && !user.equals("admin")){
		%>
		
    	<ul>
            <li><a href="BookList.jsp" class="current">Home</a></li>
            <li><a href="CartList.jsp">Cart</a></li>     
            <li><a href="MyOrders.jsp">Orders</a></li> 
            <li><a href="MyPofile.jsp">My Profile</a></li> 
            <li><a href="ContactUs.jsp">Contact Us</a></li>
            <li style="float:right"><a href="Logout.jsp">Logout</a></li>
            <li style="float:right"><a href="Logout.jsp">Welcome, <%=user %></a></li>
         </ul>	
		<%	
			}
			else{
		%>
			<ul>
				<li style="float:right"><a href="Login.jsp">User Login</a></li>
				<li style="float:right"><a href="AdminLogin.jsp">Admin Login</a></li>
			</ul>
		<%		
			}
		%>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over &#8377;250
        	</p>
			<a href="#" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Oracle SQL</li>
                <li>Java 5th Edition</li>
                <li>C++</li>
            </ul>
            <a href="#" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->