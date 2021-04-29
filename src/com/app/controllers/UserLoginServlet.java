package com.app.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserLoginDao;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("useremail");
		String password = request.getParameter("password");
		//response.getWriter().println(userName + " " + password);
		
		UserLoginDao userLoginDao = new UserLoginDao();
		
		HttpSession httpSession = request.getSession();
		
		if(userLoginDao.userLogin(userName, password)) {			
			httpSession.setAttribute("user", userName);
			//response.getWriter().println(userName);
			response.sendRedirect("BookList.jsp");
		}
		else {
			httpSession.setAttribute("loginMsg", "Invalid Username Or Password, Try Again!");
			//response.getWriter().println("failed");
			response.sendRedirect("Login.jsp");
		}
		
	}

}
