package com.tcs;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginListener implements HttpSessionListener {

    public LoginListener() {
    
    }
    
    int total;
    int current;
    ServletContext context = null;
    
    public void sessionCreated(HttpSessionEvent se)  { 
        total++;
        current++;
        
        context = se.getSession().getServletContext();
        context.setAttribute("totalusers",total);
        context.setAttribute("currentusers",current);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session object Destroyed with id:"+se.getSession().getId());
    	current--; 
    	context.setAttribute("currentusers",current);
    }
	
}
