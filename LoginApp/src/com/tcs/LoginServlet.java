package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//General settings
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		//Get the request data
		String username = request.getParameter("username");
		/*String username = request.getParameter("user");*/
		String password = request.getParameter("password");
		
		//request processing logics
		/*if(username.equalsIgnoreCase("vijay") && password.equals("nayana"))
		{	writer.println("This Login is Successful...."+username);
		}else {
			writer.println("This Login is Failed....");
		}*/
		
		/*if(username.equalsIgnoreCase("vijay") && password.equals("nayana"))
		{	response.sendRedirect("http://www.tcs.com");
		}else {
			response.sendError(888,"Login Failed Try with Valid Data...");
		}*/
		
		/*if(username.equalsIgnoreCase("vijay") && password.equals("nayana"))
		{	RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("fail.html");
			dispatcher.forward(request, response);
		}*/
		
		if(username.equalsIgnoreCase("vijay") && password.equals("nayana"))
		{	writer.println("This is success");
			writer.println("That is success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessServlet");
			dispatcher.forward(request, response);
		}else {
			writer.println("This is fail<br><br>");
			writer.println("That is fail<br><br>");
			writer.println("Please enter valid data...");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
		}
		
		/*if(username.equalsIgnoreCase("vijay") && password.equals("nayana"))
		{	writer.println("<a href='http://www.facebook.com'>Click here to get facebook </a>");
		}else {
			writer.println("<a href='FailServlet'>Click here to get Fail information</a>");
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
