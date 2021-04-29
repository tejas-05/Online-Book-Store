package com.app.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection;
	
	private DBConnection() {
		
	}

	public static Connection getDatabaseConnection() {
		
		if(connection == null) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoreweb","root","root");
				//System.out.println(connection);
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	public static void main(String[] args) {
		//DBConnection.getDatabaseConnection();
	}
}
