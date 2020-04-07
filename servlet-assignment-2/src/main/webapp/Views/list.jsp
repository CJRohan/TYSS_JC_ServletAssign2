<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeList</title>
</head>
<body>
	<%
		if (!("loggedin").equals(session.getAttribute("admins")))
			response.sendRedirect("");
	%>
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME"
		method="POST"">HOME</a> |
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT"
		method="POST"">LOGOUT</a>
	<br> ${messagel}
	<div align="center">
		<a
			href="${pageContext.request.contextPath}/employeeAssignment?action=ADD">ADD
			a new user</a><br> <br>
		<table border="2" cellpadding="3" cellspacing="2">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>DOB</th>
				<th>JoinedOn</th>
				<th>DeptID</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>OfficialEmail</th>
				<th>Mobile</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.empid}</td>
					<td>${employee.name}</td>
					<td>${employee.dob}</td>
					<td>${employee.joined}</td>
					<td>${employee.deptid}</td>
					<td>${employee.designation}</td>
					<td>${employee.salary}</td>
					<td>${employee.mailid}</td>
					<td>${employee.mobile}</td>
					<td><a
						href="${pageContext.request.contextPath}/employeeAssignment?action=EDIT&id=${employee.empid}&name=${employee.name}&password=${employee.password}&mail=${employee.mailid}&dob=${employee.dob}&joined=${employee.joined}&deptid=${employee.deptid}&managerid=${employee.managerid}&designation=${employee.designation}&salary=${employee.salary}&mobile=${employee.mobile}"
						method="POST">Edit</a> | <a
						href="${pageContext.request.contextPath}/employeeAssignment?action=DELETE&id=${employee.empid}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>