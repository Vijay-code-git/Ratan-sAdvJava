package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		String[] qualification = request.getParameterValues("qualification");
	
		String gender = request.getParameter("gender");
	
		String[] technologies = request.getParameterValues("technologies");
	
		String address = request.getParameter("address");
		
		writer.println("<html>");
		writer.println("<body bgcolor='lightgreen'>");
		writer.println("<center><b><font size='6'>");
		writer.println("User Name....."+username);
		writer.println("<br><br>");
		writer.println("Password......"+password);
		writer.println("<br><br>");
	
		writer.println("Qualification<br><br>");
		for(String qual : qualification)
		{ writer.println(qual);
		  writer.println("<br><br>");
		}
	
		writer.println("Gender...."+gender);
		writer.println("<br><br>");
		
		writer.println("Technologies<br><br>");
		for(String tech : technologies)
		{ writer.println(tech);
		  writer.println("<br><br>");
		}
		
		writer.println("Address......"+address);
		writer.println("<br><br>");
		
		writer.println("Congratulations....."+username);
		writer.println("<br><br>U R Registration Success........");
		writer.println("</font></b></center></body></html>");
	}

}
