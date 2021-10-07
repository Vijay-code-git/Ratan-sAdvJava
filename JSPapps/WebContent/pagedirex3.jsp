<%@ page language="java" contentType="text/html" info="This is JSP" errorPage="myerror.jsp" buffer="1kb" session="true"
	isELIgnored="false"  isThreadSafe="true" isErrorPage="false" %>

<html>
<body>
	<%
		for(int i=0;i<100000;i++){
		out.println("JSP classes");
		}
	%>

</body>
</html>