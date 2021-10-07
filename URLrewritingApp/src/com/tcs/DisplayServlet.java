package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();//locate
		
		writer.println("user name ="+session.getAttribute("uname"));
		writer.println("<br><br>");
		writer.println("user age ="+session.getAttribute("uage"));
		writer.println("<br><br>");
		writer.println("user qualifications ="+session.getAttribute("uqual"));
		writer.println("<br><br>");
		writer.println("user designations ="+session.getAttribute("udes"));
		writer.println("<br><br>");
		writer.println("user email id ="+request.getParameter("email"));
		writer.println("<br><br>");
		writer.println("user mobile ="+request.getParameter("mobile"));
	}

}
