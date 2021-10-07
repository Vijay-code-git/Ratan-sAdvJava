package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("Connection created successfully..."+connection);
			
			PreparedStatement preparedStatement = connection.prepareStatement("update emp set esal=esal+? where esal>?");
			
			preparedStatement.setInt(1, 750);
			preparedStatement.setInt(2, 15000);
			
			
			int x = preparedStatement.executeUpdate();
			System.out.println("updated records count: "+x);
				
				
			preparedStatement.close();
			connection.close();
			System.out.println("Resources are released.....");
		}
   
}
