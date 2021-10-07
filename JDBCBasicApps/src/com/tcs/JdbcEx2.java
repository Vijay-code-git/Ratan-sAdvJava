package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx2 {
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"manager");
			System.out.println("Connection created successfully...."+connection);
			
			statement = connection.createStatement();
		
			int x =statement.executeUpdate("drop table emp");
			System.out.println("table dropped successfully..."+x);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement!=null) statement.close();
				if (connection!=null) connection.close();	
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
