package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"manager");
		System.out.println("Connection created successfully...."+connection);
		
		Statement statement = connection.createStatement();
		
		statement.addBatch("create table emp(eid number,ename varchar2(30),esal number)");
		statement.addBatch("insert into emp values(111,'ratan',10000.45)");
		statement.addBatch("insert into emp values(222,'anu',20000.45)");
		statement.addBatch("insert into emp values(333,'sravya',30000.45)");
		statement.addBatch("update emp set esal=esal+500 where esal>15000");
		statement.addBatch("drop table emp");
		
		int[] a = statement.executeBatch();
		for(int x : a) {
			System.out.println(x);
		}
		
		statement.close();
		connection.close();
		System.out.println("Resources are released successfully...");
	}
}
