package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Book;
import com.app.utility.DBConnection;

public class BookDao {

	 Connection connection = DBConnection.getDatabaseConnection();
	 PreparedStatement ps;
	 ResultSet rs;
	
	
	public boolean addBook(Book book) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("INSERT INTO books(bookname,author,category,rating,copies,bookprice,bookimage) VALUES(?,?,?,?,?,?,?)");
			
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setString(3, book.getBookCategory());
			ps.setString(4, book.getRating());
			ps.setInt(5, book.getNoOfCopies());
			ps.setInt(6, book.getBookPrice());
			ps.setBlob(7, book.getBookImage());
			
			ps.executeUpdate();
			
			flag = true;
			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}	
		return flag;
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = null;
		Book book;
		
		try {
			books = new ArrayList<Book>();
			ps = connection.prepareStatement("SELECT * FROM books");
			rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setBookCategory(rs.getString(4));
				book.setRating(rs.getString(5));
				book.setNoOfCopies(rs.getInt(6));
				book.setBookPrice(rs.getInt(7));
				book.setBookImage(rs.getBinaryStream(8));
				books.add(book);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return books;
	}
	
	public Book getBookById(int bookId) {
		Book book = null;
		
		try {
			
			ps = connection.prepareStatement("SELECT * FROM books WHERE bookid=?");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setBookCategory(rs.getString(4));
				book.setRating(rs.getString(5));
				book.setNoOfCopies(rs.getInt(6));
				book.setBookPrice(rs.getInt(7));
				book.setBookImage(rs.getBinaryStream(8));
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return book;
	}
	
	
	public boolean updateBook(Book book) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("UPDATE books SET bookid=?,bookname=?,author=?,category=?,rating=?,copies=?,bookprice=? WHERE bookid=?");
			
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getAuthorName());
			ps.setString(4, book.getBookCategory());
			ps.setString(5, book.getRating());
			ps.setInt(6, book.getNoOfCopies());
			ps.setInt(7, book.getBookPrice());
			ps.setInt(8, book.getBookId());
			
			ps.executeUpdate();
			
			flag = true;
		
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return flag;
	}
	
	public boolean deleteBookById(int bookId) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("DELETE FROM books WHERE bookid=?");
			ps.setInt(1, bookId);
			ps.executeUpdate();
			
			flag = true;
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

















