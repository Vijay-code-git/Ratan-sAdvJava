package com.tcs;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;
	
public class JdbcEx5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			System.out.println("Connection created successfully..."+connection);
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
			
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				
				System.out.println("Enter emp id: ");
				int eid = scanner.nextInt();
				
				System.out.println("Enter emp name: ");
				String ename = scanner.next();
				
				System.out.println("Enter emp salary: ");
				double esal = scanner.nextDouble();
				
				preparedStatement.setInt(1, eid);
				preparedStatement.setString(2, ename);
				preparedStatement.setDouble(3, esal);
				
				preparedStatement.executeUpdate();
				
				System.out.println("data inserted successfully.. Do you want to insert one more record(yes/no)");
				String option = scanner.next();
				if(option.equals("no"))
					break;
			}
			
			scanner.close();
			preparedStatement.close();
			connection.close();
			System.out.println("Resources are released.....");
		}
   
}
