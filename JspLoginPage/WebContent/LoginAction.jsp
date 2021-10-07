<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<%-- This is declaration : declaration --%>
<%!
	String username;
	String password;
%>

<%-- This is block of java code: scriptlet --%>
<%
	username = request.getParameter("username");
	password = request.getParameter("password");
	
	if(username.equals("vijay") && password.equals("anu"))
	{	/* out.println("Login Successful....."+username); */
		response.sendRedirect("http://www.facebook.com");
	}else{
		/* out.println("Login Failed Please try with valid data"); */
		response.sendError(777, "login fail try with valid username & password");
	}
%>

<%-- Print the variables : expression --%>
<br><br>
User Name : <%=username%> <br><br>
Password  : <%=password%>
</body>
</html>