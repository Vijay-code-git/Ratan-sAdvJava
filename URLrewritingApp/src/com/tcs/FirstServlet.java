package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FirstServlet() {
        super();
    }

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String uage = request.getParameter("uage");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("uname", uname);
		session.setAttribute("uage", uage);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<form method='post' action="+response.encodeUrl("./SecondServlet")+">");
		writer.println("<br><br>");
		
		writer.println("user qualificatins :<input type='text' name='uqual'/>");
		writer.println("<br><br>");
		writer.println("user designation : <input type='text' name='udes'/>");
		writer.println("<br><br>");
		writer.println("<input type='submit' value='next'/>");
		
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
