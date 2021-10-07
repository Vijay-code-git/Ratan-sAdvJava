<%@ page language="java" contentType="text/html" import="java.util.Date"%>
<html>
<body>
<%String uname = (String)pageContext.getAttribute("uname",PageContext.APPLICATION_SCOPE);
out.println("Welcome="+uname+" "+new Date());
%>
</body>
</html>