package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String tname = request.getParameter("tname");

		ServletContext context = getServletContext();
		Connection connection = (Connection) context.getAttribute("conn");
		try {
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select * from " + tname);

			while (set.next()) {
				writer.println(set.getInt(1) + "---" + set.getString(2) + "---" + set.getDouble(3));
				writer.println("<br><br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
