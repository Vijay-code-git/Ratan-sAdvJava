<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<jsp:plugin code="AppletDemo" codebase="AppletDemo" width="200" height="200" type="applet">
<jsp:params>
	<jsp:param value="ratan software solutions" name="message1"/>
	<jsp:param value="vijay software solutions" name="message2"/>
</jsp:params>
	<jsp:fallback>
		<p>Unable to load applet</p>
	</jsp:fallback>
</jsp:plugin>
</body>
</html>