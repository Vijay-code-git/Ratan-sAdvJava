package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<center> <h1>");
		writer.println("*******Complete details*******");
		writer.println("<br><br>");

		writer.println("user name: " + cookies[0].getValue() + "<br><br>");
		writer.println("user age: " + cookies[1].getValue() + "<br><br>");
		writer.println("user qualification: " + cookies[2].getValue() + "<br><br>");
		writer.println("user designation: " + cookies[3].getValue() + "<br><br>");

		writer.println("user mobile: " + request.getParameter("mobile") + "<br><br>");
		writer.println("user email: " + request.getParameter("email") + "<br><br>");

		writer.println("</h1></center>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
