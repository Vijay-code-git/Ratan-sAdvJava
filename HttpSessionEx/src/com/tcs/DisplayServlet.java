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
		
		HttpSession session = request.getSession(false);
		
		writer.println("<html>");
		writer.println("<body bgcolor='powderblue'>");
		writer.println("<center> <h1>");
		writer.println("*******Complete details*******");
		writer.println("<br>");
		
		writer.println("user name: "+session.getAttribute("uname")+"<br><br>");
		writer.println("user age: "+session.getAttribute("uage")+"<br><br>");	
		writer.println("user qualification: "+session.getAttribute("uqual")+"<br><br>");		
		writer.println("user designation: "+session.getAttribute("udes")+"<br><br>");
				
		writer.println("user mobile: "+request.getParameter("mobile")+"<br><br>");		
		writer.println("user email: "+request.getParameter("email")+"<br><br>");
				
		writer.println("</h1></center>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
