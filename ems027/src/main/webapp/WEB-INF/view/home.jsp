<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	Home Page

	<table class="table table-hover table-info">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Emp ID</th>
				<th scope="col">Emp Name</th>
				<th scope="col">Email</th>
				<th scope="col">Pasword</th>
				<th scope="col">Gender</th>
				<th scope="col">DOB</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
		
		
		<c:forEach var="row" items="${allemp}">
		<tr>
				<td><c:out value="${row.employeeId}"/></td>
				<td><c:out value="${row.employeeName}"/></td>
				<td><c:out value="${row.email}"/></td>
				<td><c:out value="${row.password}"/></td>
				<td><c:out value="${row.gender}"/></td>
				<td><c:out value="${row.dob}"/></td>
				<td><a href="edit?employeeId=${row.employeeId}&employeeName=${row.employeeName}&email=${row.email}&password=${row.password}&gender=${row.gender}&dob=${row.dob}">Edit</a></td>
				<td><a href="delete?employeeId=${row.employeeId}">Delete</a></td>
			</tr>
		</c:forEach>	
		
		</tbody>
	</table>

</body>
</html>