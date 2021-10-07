package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
			
	//		Connection connection = ConnUtils.dataSource.getConnection();
			
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/mypool");
			Connection connection = ds.getConnection();
			
			java.sql.Statement statement = connection.createStatement();
			ResultSet set= statement.executeQuery("select * from Customer");
			
			writer.println("<b>FirstName LastName Email Mobile Address</b><br>");
			while(set.next())
			{ writer.println(set.getString(1)+" "+set.getString(2)+" "+set.getString(3)+" "+set.getString(4)+" "+set.getString(5));
			  writer.println("<br>");
			}
			writer.println("<a href='customer.html'>Click here to Add records..</a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
