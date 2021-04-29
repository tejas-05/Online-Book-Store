package com.app.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.BookDao;
import com.app.pojo.Book;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("image/*");
		
		int bookId = Integer.parseInt(request.getParameter("id"));
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBookById(bookId);
		
		InputStream bookImage = book.getBookImage();
		
		OutputStream out = response.getOutputStream();
		
		int i = 0;
		
		while((i = bookImage.read()) != -1) {
			out.write(i);
		}
		bookImage.close();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
