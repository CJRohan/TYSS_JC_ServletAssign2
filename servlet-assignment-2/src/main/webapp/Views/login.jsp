<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
if (session.getAttribute("admin") != null)
	response.sendRedirect("Views/welcome.jsp");
%>
<header class = "card-header text-center">Employee Management Portal</header>
<h3 align = "center">${message}</h3>
<br><br>
<h1 align="center">LOGIN PAGE</h1>
<br><br><br>
<div align = "center" class = "form-group">
<form action = "${pageContext.request.contextPath}/employeeAssignment" method="POST">
<input type="hidden" name="action" value="LOGIN">
<input type="text" name="admin" placeholder="Admin Name"><br><br>
<input type="password" name="pass" placeholder="Password"><br><br>
<input class = "btn btn-primary" type="submit" value="LOGIN">
</form>
</div>
</body>
</html>