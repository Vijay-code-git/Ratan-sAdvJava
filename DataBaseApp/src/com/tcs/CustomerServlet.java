package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		String[] addr = request.getParameterValues("t1");
		
		StringBuffer buffer = new StringBuffer();
		for(String data : addr)
		{ buffer.append(data+",");
		}
		String caddr = buffer.toString();
		
	try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");*/
			
		//	Connection connection = ConnUtils.dataSource.getConnection();
			
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/mypool");
			Connection connection = ds.getConnection();
		
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Customer values(?,?,?,?,?)");
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, mobile);
			preparedStatement.setString(5, caddr);
		
			int a = preparedStatement.executeUpdate();
			if (a == 1) {
				writer.println("Data inserted successfully....");
				writer.println("<a href='DisplayServlet'>Click here to Display all records..</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
     }
}
