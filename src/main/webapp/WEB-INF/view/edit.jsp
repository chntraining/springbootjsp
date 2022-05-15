<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
			Edit here		
			
	<div class="container-fluid">
		<div class="col align-self-center">
	
		  <form action="updateEmpl" method="get">
				<div class="form-group">
					<label for="eid" class="col-sm-2 col-form-label">Emp ID</label> <input
						type="text" class="form-control" size="20" name="employeeId"
						value="${param.employeeId}" readonly="readonly" />
				</div>
				<div class="form-group">
					<label for="ename" class="col-sm-2 col-form-label">Emp Name</label>
					<input type="text" class="form-control" name="employeeName"  value="${param.employeeName}" size="20"
						pattern="^[a-zA-Z\s]{1,15}$" required />
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<input type="email" class="form-control" name="email"  value="${param.email}"  size="20"
						readonly="readonly" />
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 col-form-label">Password</label>
					<input type="text" class="form-control" name="password"  value="${param.password}"  size="20"
						required />
				</div>
				<div class="form-group">
					<label for="gender" class="col-sm-2 col-form-label">Gender</label>
					<input type="text" class="form-control" name="gender"  value="${param.gender}"  size="20"
						required />
				</div>
				<div class="form-group">
					<label for="dob" class="col-sm-2 col-form-label">Date of Birth</label> 
					 <input type="date" name="dob" value="${param.dob}" placeholder="yyyy-mm-dd"/>
				</div>
				<div class="form-group">
					<input type="submit" name="updateEmpl" value="UPDATE"  class="btn btn-primary"/>
				</div>
			</form>
		</div>

	</div>
</body>
</html>