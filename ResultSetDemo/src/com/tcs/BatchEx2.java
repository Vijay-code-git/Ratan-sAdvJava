package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchEx2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"manager");
		System.out.println("Connection created successfully...."+connection);
		
		PreparedStatement preparedStatement = connection.prepareStatement("update emp set ename=? where eid=?");
		preparedStatement.setString(1, "Ram");
		preparedStatement.setInt(2,111);
		preparedStatement.addBatch();
		
		preparedStatement.setString(1, "Anushka");
		preparedStatement.setInt(2,222);
		preparedStatement.addBatch();
		
		preparedStatement.setString(1, "Sam");
		preparedStatement.setInt(2,333);
		preparedStatement.addBatch();
		
		connection.close();
		System.out.println("Connection closed successfully...");
	}
}
