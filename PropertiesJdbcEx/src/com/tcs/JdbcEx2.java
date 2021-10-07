package com.tcs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx2 {
	public static void main(String[] args) throws SQLException {
		Connection connection = TestConn.createConnection();
		
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select * from emp");
		
		ResultSetMetaData metaData = set.getMetaData();
		System.out.println(metaData.getColumnCount());
		
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getColumnDisplaySize(2));
		System.out.println(metaData.getColumnTypeName(2));
		
		connection.close();
		System.out.println("Resources are released successfully...");
	}
}
