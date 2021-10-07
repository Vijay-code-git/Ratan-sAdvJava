package com.tcs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableEx3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	System.out.println("connection created successfully.....");
	
	CallableStatement callableStatement = connection.prepareCall("{call getDetails(?,?,?,?)}");
	callableStatement.setInt(1, 999);
	callableStatement.registerOutParameter(2, Types.INTEGER);
	callableStatement.registerOutParameter(3, Types.VARCHAR);
	callableStatement.registerOutParameter(4,Types.FLOAT);
	callableStatement.executeUpdate();
	
	System.out.println(callableStatement.getInt(2));
	System.out.println(callableStatement.getString(3));
	System.out.println(callableStatement.getFloat(4));
	System.out.println("operations are completed");
	
	callableStatement.close();
	connection.close();
	System.out.println("connection is closed");
	}
}
