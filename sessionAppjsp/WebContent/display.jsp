<%@ page language="java" contentType="text/html" import="java.sql.*"%>
<html>
<body bgcolor="purple">
	
	<%!
		Connection connection;
		PreparedStatement preparedStatement;
	%>
	
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?)");
		preparedStatement.setString(1,(String)session.getAttribute("username"));
		preparedStatement.setInt(2,(Integer)session.getAttribute("age"));
		preparedStatement.setString(3,(String)session.getAttribute("qualification"));
		preparedStatement.setString(4,(String)session.getAttribute("designation"));
		preparedStatement.setString(5,(String)request.getParameter("mobile"));
		preparedStatement.setString(6,(String)request.getParameter("email"));
		preparedStatement.executeUpdate();
		out.println("<center>Data inserted successfully....</center>");
	%>
</body>
</html>