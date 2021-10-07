package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//step1 : Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loading completed...");
		
		//step2 : create the connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"manager");
		System.out.println("Connection created successfully...."+connection);
		
		//step3 : create the statement object
		Statement statement = connection.createStatement();
		
		//step4 : process the querry
		int x = statement.executeUpdate("create table emp(eid number,ename varchar2(30),esal number)");
		System.out.println("Table created sucessfully..."+x);
		
		//step5 : release the resources
		statement.close();
		connection.close();
		System.out.println("Connection closed successfully...");
	}
}
