<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<%! 
		int eid;
		String ename;
		double esal;
	%>
	
	<%
		eid = Integer.parseInt(request.getParameter("eid"));
		ename = request.getParameter("ename");
		esal = Double.parseDouble(request.getParameter("esal"));
	%>
	
	<!-- Configure the bean class -->
	<jsp:useBean id="eb" class="com.tcs.EmpBean" scope="application"/>
	
	<!-- set the data to bean class object using setter method -->
	<jsp:setProperty property="eid" name="eb" value="<%=eid%>"/>
	<jsp:setProperty property="ename" name="eb" value="<%=ename%>"/>
	<jsp:setProperty property="esal" name="eb" value="<%=esal%>"/>
	
	<!-- get the data from bean class using getter method -->
	Emp Id : <jsp:getProperty property="eid" name="eb"/> <br><br>
	Emp Name : <jsp:getProperty property="ename" name="eb"/> <br><br>
	Emp Salary : <jsp:getProperty property="esal" name="eb"/>
</body>
</html>