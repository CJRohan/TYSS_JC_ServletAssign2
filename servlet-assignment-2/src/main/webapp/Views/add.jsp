<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
if (session.getAttribute("admin") == null)
	response.sendRedirect("");
%>
<header class = "card-header text-center">Employee Management Portal</header>
<div class = " text-right">
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME" method = "POST" class = "btn btn-success">HOME</a>
    
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT" method = "POST" class = "btn btn-warning">LOGOUT</a>
	</div><br>
	<div class = "text-center"><a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LIST" class = "btn btn-link">LIST
		the Employees</a>
		</div>
	<br>
	<h2 align = "center">${message}</h2>
	<div class = "form-group text-center">
	<form action="${pageContext.request.contextPath}/employeeAssignment" >
		<input type="hidden" name="action" value="ADDEmployee"> 
		<input type="hidden" name="id" value="${id}"> 
		<input type="text" name="name" value = "${name}" placeholder = "Employee Name"><br><br>
		<input type="text" name="mail" value = "${mail}" placeholder = "Official EmailID"><br> <br>
		 <p class = "btn btn-dark"> Date of Birth </p> &emsp;&emsp; <p class = "btn btn-dark"> Joining Date </p> <br>
		 <input type="date" name="dob" value = "${dob}" >&ensp;<input type="date" name="joined" value = "${joined}"> <br><br> 
		<input type="text" name="deptid" value = "${deptid}" placeholder = "Department ID"><br><br> 
		<input type="text" name="designation" value = "${designation}" placeholder = "Designation"><br><br> 
		<input type="text" name="salary" value = "${salary}" placeholder = "Salary"><br> <br>
		<input type="text" name="managerid" value = "${managerid}" placeholder = "Manager ID"><br><br> 
		<input type="text" name="mobile" value = "${mobile}" placeholder = "Mobile"><br> <br>
		<input type="text" name="password" value = "${password}" placeholder = "Password"><br> <br>
		<input type="submit" value="ADD" class = "btn btn-primary">
	</form>
	</div>
</body>
</html>