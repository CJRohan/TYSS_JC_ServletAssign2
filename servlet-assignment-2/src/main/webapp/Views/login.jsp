<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link href = "https://unpkg.com/browse/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%
if (("loggedin").equals(session.getAttribute("admins")))
	response.sendRedirect("employeeAssignment?action=WELCOME");
%>

<h3>${message}</h3>
<br><br>
<h1 align="center">LOGIN PAGE</h1>
<br><br><br>
<div align = "center">
<form action="${pageContext.request.contextPath}/employeeAssignment" method="POST">
<input type="hidden" name="action" value="LOGIN">
<input type="text" name="admin" placeholder="Admin Name"><br><br>
<input type="password" name="pass" placeholder="Password"><br><br>
<input type="submit" value="LOGIN">
</form>
</div>

</body>
</html>