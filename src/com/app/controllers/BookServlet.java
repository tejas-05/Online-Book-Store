package com.app.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.app.dao.BookDao;
import com.app.pojo.Book;

@MultipartConfig
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String action = request.getParameter("action");

			BookDao bookDao = new BookDao();
			
			if(action.equals("update")) {
				int bookId = Integer.parseInt(request.getParameter("id"));
				Book book = bookDao.getBookById(bookId);
				
				//response.getWriter().println(book);
				request.setAttribute("book",book);
				
				RequestDispatcher rd = request.getRequestDispatcher("UpdateBook.jsp");
				rd.forward(request, response);
			}
			
			else if(action.equals("delete")) {
				int bookId = Integer.parseInt(request.getParameter("id"));
				
				if(bookDao.deleteBookById(bookId)) {
					request.setAttribute("BookDeleteMsg", "Book Delete Successfully!");

					RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
					rd.forward(request, response);
				}
				
				
				//response.getWriter().println(book);
				//request.setAttribute("book",book);
				
			}

		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		System.out.println(action);


		//response.getWriter().println(action);
		
		if (action != null && action.equals("add")) {

			String bookName = request.getParameter("bookname");
			String authorName = request.getParameter("authorname");
			String bookCategory = request.getParameter("bookcategory");
			
			// for storing image
			Part part = request.getPart("bookimage");
			InputStream bookImage = part.getInputStream();
			//String bookImage = request.getParameter("bookimage");
			
			
			int noOfCopies = Integer.parseInt(request.getParameter("noOfCopies"));
			String rating = request.getParameter("rating");
			int bookPrice = Integer.parseInt(request.getParameter("bookprice"));

			PrintWriter out = response.getWriter();
			// out.println(bookName + " " + authorName + " "+bookCategory +" " + bookImage +
			// " " + rating + " " + noOfCopies + " " + bookPrice);

			Book book = new Book();
			book.setBookName(bookName);
			book.setAuthorName(authorName);
			book.setBookCategory(bookCategory);
			book.setBookImage(bookImage);
			book.setNoOfCopies(noOfCopies);
			book.setRating(rating);
			book.setBookPrice(bookPrice);
			book.setBookImage(bookImage);

			BookDao bookDao = new BookDao();
			boolean flag = bookDao.addBook(book);
			
			if(flag) {
				request.setAttribute("bookAddMsg", "Book Added Successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("bookAddMsg", "Book Not Added,Try Again!");
				RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
				rd.forward(request, response);
			}
		}
		
		if(action != null && action.equals("update")) {
			
			response.getWriter().println("oksdsd");
			
			int bookId = Integer.parseInt(request.getParameter("bookid"));
			String bookName = request.getParameter("bookname");
			String authorName = request.getParameter("author");
			String bookCategory = request.getParameter("bookcategory");
			int noOfCopies = Integer.parseInt(request.getParameter("noOfCopies"));
			String rating = request.getParameter("rating");
			int bookPrice = Integer.parseInt(request.getParameter("bookprice"));

			
			// for storing image
			Part part = request.getPart("bookimage");
			InputStream bookImage = part.getInputStream();
			//String bookImage = request.getParameter("bookimage");
						
			
			
			Book book = new Book();
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setAuthorName(authorName);
			book.setBookCategory(bookCategory);
			book.setBookImage(bookImage);
			book.setNoOfCopies(noOfCopies);
			book.setRating(rating);
			book.setBookPrice(bookPrice);
			

			BookDao bookDao = new BookDao();
			
			if(bookDao.updateBook(book)) {
				request.setAttribute("bookUpdateMsg", "Book Update Successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("bookUpdateMsg", "Book Is Not Updated,Try Again!");

				RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}

}













