<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeList</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<%
	if (session.getAttribute("admin") == null)
			response.sendRedirect("");
	%>
	<header class = "card-header text-center">Employee Management Portal</header>
	<div class = " text-right"> <a
		href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME"
		method="POST" class = "btn btn-success">HOME</a>
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT"
		method="POST" class = "btn btn-warning" >LOGOUT</a>
		</div>
 <br> ${messagel}
	<div align="center">
		<a
			href="${pageContext.request.contextPath}/employeeAssignment?action=ADD">ADD
			a new user</a><br> <br>
		<table class = "table-striped table-hover table-bordered text-center"  >
				<tr class = "table-info">
				<th >ID</th>
				<th>Name</th>
				<th colspan=2>DOB&emsp;&ensp;&emsp;JoinedOn<br>yyyy-mm-dd</th>
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