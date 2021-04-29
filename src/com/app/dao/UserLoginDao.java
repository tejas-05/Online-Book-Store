package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.utility.DBConnection;

public class UserLoginDao {

	private Connection connection = DBConnection.getDatabaseConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean userLogin(String userName, String password) {
		boolean flag = false;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM customers WHERE email=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				flag = true;
			}
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		
		return flag;
	}
	
	
}
