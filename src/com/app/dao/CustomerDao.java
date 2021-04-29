package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Customer;
import com.app.utility.DBConnection;

public class CustomerDao {

	private Connection connection = DBConnection.getDatabaseConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean saveCustomer(Customer c) {
		boolean flag = false;
		try {
			ps = connection.prepareStatement("INSERT INTO customers(customername,email,password,contact,city) VALUES(?,?,?,?,?)");
			ps.setString(1,c.getCustName());
			ps.setString(2, c.getCustEmail());
			ps.setString(3, c.getCustPassword());
			ps.setNString(4, c.getCustContact());
			ps.setString(5, c.getCustAddress());
			ps.executeUpdate();
			flag = true;
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return flag;
	}
	
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = null;
		Customer customer;
		
		try {
			customers = new ArrayList<Customer>();
			ps = connection.prepareStatement("SELECT * FROM customers");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustEmail(rs.getString(3));
				customer.setCustPassword(rs.getString(4));
				customer.setCustContact(rs.getString(5));
				customer.setCustAddress(rs.getString(6));
				
				customers.add(customer);
				
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return customers;
	}
	
	public Customer getCustomerByEmail(String email) {
		Customer customer = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM customers WHERE email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setCustEmail(rs.getString(3));
				customer.setCustPassword(rs.getString(4));
				customer.setCustContact(rs.getString(5));
				customer.setCustAddress(rs.getString(6));
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return customer;
	}
	
}





















