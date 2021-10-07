package com.tcs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallabelFunc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		CallableStatement callableStatement = connection.prepareCall("{? = call getAvg(?,?)}");
		
		callableStatement.setInt(2, 111);
		callableStatement.setInt(3, 222);
		
		callableStatement.registerOutParameter(1, Types.FLOAT);
		
		callableStatement.execute();
		
		System.out.println("Result..."+callableStatement.getFloat(1));
		
		callableStatement.close();
		connection.close();
		System.out.println("Resources are release Successfully....");
	}
}
