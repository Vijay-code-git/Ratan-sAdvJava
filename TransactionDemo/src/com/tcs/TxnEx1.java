package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TxnEx1 {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("connection created successfully..");
			
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			
			statement.executeUpdate("insert into emp values(111,'ratan',10000.45)");
			statement.executeUpdate("insert into emp values(222,'anu',20000.45)");
			statement.executeUpdate("insert into emp values(333,'sravya',30000.45)");
			statement.executeUpdate("update emp set esal = esal + 100 where esal>10000");
			statement.executeUpdate("delete from emp where eid = 111");
			connection.commit();
			System.out.println("transaction is successful...");
		}catch(Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("transaction is fail...");
		}
		finally {
			if(statement!=null) statement.close();
			if(connection!=null) connection.close();
		}
		System.out.println("Resources are released successfully...");
	}
}
