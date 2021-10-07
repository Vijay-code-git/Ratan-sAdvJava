package com.tcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uqual = request.getParameter("uqual");
		String udes = request.getParameter("udes");
		
		Cookie cookie3 = new Cookie("uqual", uqual);
		Cookie cookie4 = new Cookie("udes", udes);
		
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		request.getRequestDispatcher("form3.html").forward(request, response);
	}

}
