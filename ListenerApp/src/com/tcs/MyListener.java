package com.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("contextDestroyed method Connection closed");
		ServletContext context = sce.getServletContext();
		Connection connection = (Connection) context.getAttribute("conn");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized method Connection created");
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				ServletContext context = sce.getServletContext();
				context.setAttribute("conn", connection);
		}
		catch (Exception e) 
		{ 	e.printStackTrace();	
		}
	}	 
	public MyListener() {
       
    }
	
}
