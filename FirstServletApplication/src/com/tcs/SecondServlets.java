package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlets extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("This is second Servlet Application");
	}
}
