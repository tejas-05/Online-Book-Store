package com.app.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CustomerDao;
import com.app.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int custId;
		String custName, custEmail, custPassword, custContact, custAddress;
		
		custName = request.getParameter("customerName");
		custEmail = request.getParameter("email");
		custPassword = request.getParameter("password");
		custContact = request.getParameter("customerContact");
		custAddress = request.getParameter("customerAddress");

		//response.getWriter().println(custName+" " + custEmail+" "+custPassword+" "+custContact+" " +  custAddress);
		
		Customer customer = new Customer(custName, custEmail, custPassword, custContact, custAddress);
		
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.saveCustomer(customer)) {
			request.setAttribute("customerAddMsg","Register Successfully!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("customerAddMsg","Registration Failed,Try Again!");
			request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
		}
	}

}
