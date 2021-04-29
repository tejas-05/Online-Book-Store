package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Cart;
import com.app.utility.DBConnection;

public class CartDao {

	private Connection connection = DBConnection.getDatabaseConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public boolean addToCart(Cart cart) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("INSERT INTO cart(bookid,email,quantity) VALUES(?,?,?)");
			ps.setInt(1,cart.getBookId());
			ps.setString(2, cart.getCustEmail());
			ps.setInt(3, cart.getQuantity());
			ps.executeUpdate();
			flag = true;
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Cart> showCart(){
		List<Cart> carts = null;
		Cart cart;
		
		try {
			carts = new ArrayList<Cart>();
			ps = connection.prepareStatement("SELECT cart.cartid,books.bookid,books.bookname,books.bookprice,cart.email,cart.quantity FROM cart INNER JOIN books ON cart.bookid = books.bookid");
			rs = ps.executeQuery();
		
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setBookId(rs.getInt(2));
				cart.setBookName(rs.getString(3));
				cart.setBookPrice(rs.getInt(4));
				cart.setCustEmail(rs.getString(5));
				cart.setQuantity(rs.getInt(6));
				carts.add(cart);
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
	
		return carts;
	}
	
	
	public boolean removeFromCartById(int cartId) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("DELETE FROM cart WHERE cartid=?");
			ps.setInt(1, cartId);
			ps.executeUpdate();
			flag = true;
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Cart> getCartByEmail(String email){
		List<Cart> carts = null;
		Cart cart;
		
		try {
			carts = new ArrayList<Cart>();
			ps = connection.prepareStatement("SELECT cart.cartid,books.bookid,books.bookname,books.bookprice,cart.email,cart.quantity FROM cart INNER JOIN books ON cart.bookid = books.bookid WHERE email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setBookId(rs.getInt(2));
				cart.setBookName(rs.getString(3));
				cart.setBookPrice(rs.getInt(4));
				cart.setCustEmail(rs.getString(5));
				cart.setQuantity(rs.getInt(6));
				carts.add(cart);
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
	
		return carts;
	}
	
}















