<%@ page language="java" contentType="text/html"%>
<html>
<body>
<%
	out.println("This is Working with PageContext object.....<br>");
	String uname = request.getParameter("uname");
	pageContext.setAttribute("uname",uname, PageContext.APPLICATION_SCOPE);
	out.println("<a href='second.jsp'>click here to get msg</a>");
%>
</body>
</html>