<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<%
if (!("loggedin").equals(session.getAttribute("admins")))
	response.sendRedirect("");
%>
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME" method = "POST">HOME</a>
	|
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT" method = "POST"">LOGOUT</a>
	<br>
	<br>
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LIST">LIST
		the Employees</a>
	<br>
	<br>
	<h4>${message}</h4>
	<form action="${pageContext.request.contextPath}/employeeAssignment">
		<input type="hidden" name="action" value="ADDEmployee"> 
		<input type="hidden" name="id" value="${id}"> 
		Employee Name: <input type="text" name="name" value = "${name}"><br>
		Official EmailID: <input type="text" name="mail" value = "${mail}"><br> 
		Date of Birth: <input type="date" name="dob" value = "${dob}"><br> 
		Joining Date: <input type="date" name="joined" value = "${joined}"><br> 
		Department ID: <input type="text" name="deptid" value = "${deptid}"><br> 
		Designation: <input type="text" name="designation" value = "${designation}"><br> 
		Salary: <input type="text" name="salary" value = "${salary}"><br> 
		Manager ID: <input type="text" name="managerid" value = "${managerid}"><br> 
		Mobile: <input type="text" name="mobile" value = "${mobile}"><br> 
		Password: <input type="text" name="password" value = "${password}"><br> 
		<input type="submit" value="ADD">
	</form>
</body>
</html>