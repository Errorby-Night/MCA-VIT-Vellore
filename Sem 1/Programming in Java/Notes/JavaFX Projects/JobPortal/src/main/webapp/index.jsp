<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
	<h1> Enter your details. </h1>
	<form action="RegistrationCheck.jsp" method="post">
	Enter your name: <input type="text" name="name"><br>
	Enter your registration number: <input type="text" name="reg"><br>
	Enter your branch: <input type="text" name="branch"><br>
	Enter your year: <input type="text" name="year"><br>
	<input type="submit">
	</form>
</body>
</html>