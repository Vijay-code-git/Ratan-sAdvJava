package com.tcs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableEx1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//execution of procedures
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("Connection created Successfully..."+connection);
		
		CallableStatement callableStatement = connection.prepareCall("{call getSal(?,?)}");
		callableStatement.setInt(1, 111);
		callableStatement.registerOutParameter(2, Types.DOUBLE);
		
		callableStatement.execute();
		
		System.out.println("Result..."+callableStatement.getDouble(2));
		
		callableStatement.close();
		connection.close();
		System.out.println("Resources are released successfully...");
	}
}
