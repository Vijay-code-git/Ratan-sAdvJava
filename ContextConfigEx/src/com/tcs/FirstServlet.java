package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		ServletConfig config = this.getServletConfig();
		writer.println("First Servlet init param-1: "+config.getInitParameter("homeloan"));
		writer.println("<br><br>");
		writer.println("First Servlet init param-2: "+config.getInitParameter("carloan"));
		writer.println("<br><br>");
		
		ServletContext context = request.getServletContext();
		writer.println("First Servlet context param-1: "+context.getInitParameter("username"));
		writer.println("<br><br>");
		writer.println("First Servlet context param-2: "+context.getInitParameter("password"));
		writer.println("<br><br>");
	}
}
