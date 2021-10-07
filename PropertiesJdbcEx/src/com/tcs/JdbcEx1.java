package com.tcs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JdbcEx1 {
	public static void main(String[] args) throws SQLException {
		Connection connection = TestConn.createConnection();
		
	//	System.out.println(connection);
		DatabaseMetaData metaData = connection.getMetaData();
		
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(metaData.getDatabaseProductVersion());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getURL());
		System.out.println(metaData.getDriverName());
		
		connection.close();
		System.out.println("Resources are released successfully...");
	}
}
