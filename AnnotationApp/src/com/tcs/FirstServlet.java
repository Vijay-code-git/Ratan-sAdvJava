package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/FirstServlet" }, initParams = { @WebInitParam(name = "user1", value = "ratan"),
		@WebInitParam(name = "user2", value = "anu") })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.println("This is annotated Servlet....");

		ServletConfig config = this.getServletConfig();
		writer.println(config.getInitParameter("user1"));
		writer.println("<br><br>");
		writer.println(config.getInitParameter("user2"));
	}
}
