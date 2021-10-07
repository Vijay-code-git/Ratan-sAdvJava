package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		out.print("Welcome " + n);
		HttpSession session = request.getSession();

		// retrieving data from ServletContext object
		ServletContext ctx = getServletContext();
		int t = (Integer) ctx.getAttribute("totalusers");
		int c = (Integer) ctx.getAttribute("currentusers");
		out.print("<br>total users= " + t);
		out.print("<br>current users= " + c);
		out.print("<br><a href='LogoutServlet'>logout</a>");
		out.close();
	}

}
