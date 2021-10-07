<%@ page language="java" contentType="text/html" import="java.util.Date" %>

<html>
<body>
	<%! 
		Date d = null; 
	%>
	
	<%
		d = new Date();
	%>
	
	Today Date: <%=d%>
	
</body>
</html>