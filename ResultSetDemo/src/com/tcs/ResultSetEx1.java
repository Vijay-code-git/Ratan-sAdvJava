package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"manager");
		System.out.println("Connection created successfully...."+connection);
		
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet set = statement.executeQuery("select * from emp");
		set.afterLast();
		while(set.previous()) {
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getDouble(3));
		}
		
		set.first();
		System.out.println(set.getInt(1));
		
		set.last();
		System.out.println(set.getInt(1));
		
		set.absolute(2);
		System.out.println(set.getInt(1));
		
		set.close();
		statement.close();
		connection.close();
		System.out.println("Resources are released successfully");
	}
}

