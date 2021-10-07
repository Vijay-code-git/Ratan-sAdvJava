package com.tcs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableEx2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		System.out.println("connection created successfully.....");
		
		CallableStatement callableStatement = connection.prepareCall("{call insert11(?,?,?)}");
		callableStatement.setInt(1, 777);
		callableStatement.setString(2, "ccc");
		callableStatement.setInt(3, 5000);
		
		callableStatement.executeUpdate();
		System.out.println("operations are completed");
		
		callableStatement.close();
		connection.close();
		System.out.println("connection is closed");
	}
}
