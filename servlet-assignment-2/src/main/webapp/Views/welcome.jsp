<%@page import="com.tyss.beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
if (session.getAttribute("admin") == null)
	response.sendRedirect("");
%>
<header class = "card-header text-center">Employee Management Portal</header>
	<div class = " text-right"><a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT"
		method="POST" class = "btn btn-warning">LOGOUT</a>
		</div><br>
	<br>
	<div class = "text-center">
		<h1>Welcome <%= ((Login)session.getAttribute("admin")).getAdmin() %></h1>
	</div><br><br>
	<br>
	<div align="center">
	
		<a
			href="${pageContext.request.contextPath}/employeeAssignment?action=ADD" class = "btn btn-link">Add
			User</a> <br> <br> <a
			href="${pageContext.request.contextPath}/employeeAssignment?action=LIST" class = "btn btn-link">View
			Users</a> <br> <br> <form
			action="${pageContext.request.contextPath}/employeeAssignment">
			<input type = "hidden" name = "action" value = "GET">
			Search by ID : <input type = "text" name = "id">
			<input type = "submit" value = "Search" class = "btn btn-primary">
			<br>${message}</form>
	</div>
</body>
</html>