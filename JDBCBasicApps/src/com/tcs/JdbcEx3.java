package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx3 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery("select * from emp");
			/*while (set.next()) {
				System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
			}*/
			while (set.next()) {
				System.out.println(set.getInt("eid")+" "+set.getString("ename")+" "+set.getFloat("esal"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
