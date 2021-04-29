package com.app.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.app.dao.OrderDao;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		response.getWriter().print(action);
		
		int orderId = Integer.parseInt(request.getParameter("orderid"));

		OrderDao orderDao = new OrderDao();
		
		if (action.equals("cencel")) {
			orderDao.deleteOrderById(orderId);
			response.sendRedirect("OrdersList.jsp");
		}
		else if(action.equals("proceed")) {
			orderDao.updateOrderStatus(orderId);
			response.sendRedirect("OrdersList.jsp");
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession httpSession = request.getSession();
		String email = (String) httpSession.getAttribute("user");
		
		int totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
		//response.getWriter().print(totalAmount + " " + email);
		
		OrderDao orderDao = new OrderDao();
		if(orderDao.placeOrder(email, totalAmount)) {
			response.getWriter().print("ok");
		}
		else {
			response.getWriter().print("fail");
		}
		
	}

}
