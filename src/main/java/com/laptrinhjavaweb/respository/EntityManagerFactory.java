package com.laptrinhjavaweb.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityManagerFactory {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspservlet122019";
			String user="root";
			String password="Kieuanh";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
			return null;
			
		}
		
	}

}
