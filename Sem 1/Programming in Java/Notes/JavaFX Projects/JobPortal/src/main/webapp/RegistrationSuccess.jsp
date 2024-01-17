<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<h1>Registration successful..</h1>
	<h2>Name: <%=request.getAttribute("name") %></h2>
	<h2>Registration number: <%=request.getAttribute("reg") %></h2>
	<h2>Branch: <%=request.getAttribute("branch") %></h2>
	<h2>Year: <%=request.getAttribute("year") %></h2>
</body>
</html>