<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    	String user = (String) session.getAttribute("user");
        
    		if (user == null) {
    			response.sendRedirect("Login.jsp");
    		}
    		else if (user.equals("admin")) {
    			session.invalidate();
    			response.sendRedirect("AdminLogin.jsp");
    		} else {
    			session.invalidate();
    			response.sendRedirect("Login.jsp");
    		}
    %>