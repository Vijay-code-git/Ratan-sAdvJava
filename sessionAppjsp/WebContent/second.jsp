<%@ page language="java" contentType="text/html"%>
<html>
<body>
	<%!
		String qualification;
		String designation;
	%>
	
	<%
		qualification = request.getParameter("qualification");
		designation = request.getParameter("designation");
			
		session.setAttribute("qualification", qualification);
		session.setAttribute("designation", designation);
	%>
	
	<jsp:forward page="form3.html"/>
	
</body>
</html>