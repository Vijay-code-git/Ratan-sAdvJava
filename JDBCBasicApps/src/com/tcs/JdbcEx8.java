package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx8 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		System.out.println("Connection created successfully..."+connection);
		
		Statement statement = connection.createStatement();
		String q1 = "select * from emp";
		String q2 = "update emp set esal=esal+100 where esal>500";
		
		boolean b = statement.execute(q2);
		
		if (b) {
			System.out.println("statement selection...");
			ResultSet set = statement.getResultSet();
			while (set.next()) {
				System.out.println(set.getInt(1)+"  "+set.getString(2)+"  "+set.getDouble(3));
			}
		} else {
			int a = statement.getUpdateCount();
			System.out.println("records are updated: "+a);
		}
		connection.close();
		System.out.println("Resources are released....");
	}
}
