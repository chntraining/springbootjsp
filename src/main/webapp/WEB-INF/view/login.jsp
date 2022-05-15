<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	Login here
	
	<h3 style="color:red">${NOTIFICATION}</h3>
	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="signin" method="GET">
				<div class="form-group">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<input type="email" class="form-control" name="txtemail" size="20"
						required />
				</div>
				<div class="form-group">
					<label for="pass" class="col-sm-2 col-form-label">Password</label>
					<input type="password" class="form-control" name="txtpass" size="20"
						required />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>