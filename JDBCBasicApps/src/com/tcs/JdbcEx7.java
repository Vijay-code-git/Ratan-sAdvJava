package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEx7 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("Connection created successfully..."+connection);
		
		PreparedStatement preparedStatement = connection.prepareStatement("select ename,esal from emp where esal<?");
		preparedStatement.setInt(1, 15000);
		
		ResultSet set = preparedStatement.executeQuery();
			while(set.next()) {
				System.out.println(set.getString(1)+" "+set.getDouble(2));
			}
			
		preparedStatement.close();
		connection.close();
		System.out.println("Resources are released.....");
	}

}
