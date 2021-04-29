package com.app.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CartDao;
import com.app.pojo.Cart;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		HttpSession httpSession = request.getSession();
	
		if (action != null && action.equals("addtocart")) {
			int bookId = Integer.parseInt(request.getParameter("id"));
			String custEmail = (String) httpSession.getAttribute("user");
			//response.getWriter().print(action + " " + bookId + " " + custEmail);
			int quantity = 1;
			
			response.getWriter().print(action);
			
			Cart cart = new Cart();
			cart.setBookId(bookId);
			cart.setCustEmail(custEmail);
			cart.setQuantity(quantity);

			CartDao cartDao = new CartDao();
			cartDao.addToCart(cart);
		}
		
		else if(action != null && action.equals("remove")) {
			int cartId = Integer.parseInt(request.getParameter("id"));
			//response.getWriter().print(action);
			
			CartDao cartDao = new CartDao();
			if(cartDao.removeFromCartById(cartId)) {
				response.getWriter().print("ok");
			}else {
				response.getWriter().print("fail");
			}
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
