package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Order;
import com.app.utility.DBConnection;

public class OrderDao {

	private Connection connection = DBConnection.getDatabaseConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public boolean placeOrder(String email, int totalAmount) {
		boolean flag = false;
		String orderDate = LocalDate.now().toString();
		String orderStatus = "Pending";
		try {
			ps = connection.prepareStatement("INSERT INTO orders(customer_email,order_status,order_date,total_amount) VALUES(?,?,?,?)");
			ps.setString(1,email);
			ps.setString(2, orderStatus);
			ps.setString(3, orderDate);
			ps.setInt(4, totalAmount);
			ps.executeUpdate();
			
			flag = true;
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Order> getAllOrders(){
		List<Order> orders = null;
		Order order;
		
		try {
			
			orders = new ArrayList<Order>();
			
			ps = connection.prepareStatement("SELECT * FROM orders WHERE order_status=?");
			ps.setString(1, "Pending");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setCustEmail(rs.getString(2));
				order.setOrderStatus(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setTotalPrice(rs.getInt(5));
				
				orders.add(order);
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return orders;
	}
	
	
	public List<Order> getAllOrdersByEmail(String email){
		List<Order> orders = null;
		Order order;
		
		try {
			orders = new ArrayList<Order>();
			ps = connection.prepareStatement("SELECT * FROM orders WHERE customer_email=?");
			ps.setString(1,email);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setCustEmail(rs.getString(2));
				order.setOrderStatus(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setTotalPrice(rs.getInt(5));	
				orders.add(order);
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		
		return orders;
	}
	
	public boolean deleteOrderById(int orderId) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("DELETE FROM orders WHERE orderid=?");
			ps.setInt(1, orderId);
			ps.executeUpdate();
			
			flag = true;
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean updateOrderStatus(int orderId) {
		boolean flag = false;
		try {
			ps = connection.prepareStatement("UPDATE orders SET order_status=? WHERE orderid=?");
			ps.setString(1, "Proceed");
			ps.setInt(2, orderId);
			ps.executeUpdate();
			
			flag = true;
		}catch(SQLException s) {
			s.printStackTrace();
		}	
		return flag;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
