<%@ page language="java" contentType="text/html" import="java.util.*"%>
<jsp:declaration>
  	Date d = null;
  	String date = null;
</jsp:declaration>

<jsp:scriptlet>
	d = new Date();
	date = d.toString();
</jsp:scriptlet>	

<html>
<body bgcolor="lightyellow">
<center><b><font size="6" color="red"><br><br>
Today Date : <jsp:expression>date</jsp:expression>
</font></b></center>
</body>
</html>