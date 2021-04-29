package com.app.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.getWriter().println(userName + " " + password);
		
		HttpSession httpSession = request.getSession();
		
		if(userName.equals("admin") && password.equals("admin")) {
			httpSession.setAttribute("user", "admin");
			response.sendRedirect("AddBook.jsp");
		}
		else {
			httpSession.setAttribute("loginMsg", "Invalid Username Or Password, Try Again!");
			response.sendRedirect("AdminLogin.jsp");
		}
	
	}

}
