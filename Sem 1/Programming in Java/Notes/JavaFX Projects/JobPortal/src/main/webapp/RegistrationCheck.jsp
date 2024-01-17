<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration check</title>
</head>
<body>
	<h1>Registration checking...</h1>
	<%
		int flag = 0;
		String name = request.getParameter("name");
		String reg = request.getParameter("reg");
		String branch = request.getParameter("branch");
		String year = request.getParameter("year");
		
		if(name.equals("") || reg.equals("") || branch.equals("") || year.equals(""))
			flag++;
		else
		{
			if(!reg.matches("\\d{2}[A-Z]{3}\\d{4}"))
				flag++;
			
			int y = Integer.parseInt(year);
			if(y<1 || y>2)
				flag++;
		}
		if(flag == 0)
		{
			request.setAttribute("name", name);
			request.setAttribute("reg", reg);
			request.setAttribute("branch", branch);
			request.setAttribute("year", year);
			request.getRequestDispatcher("RegistrationSuccess.jsp").forward(request,response);
		}
		if(flag >= 1)
		{
	%>		
		<script>
			alert("Please fill all the fields appropriatly.");
			window.location.href = "RegistrationForm.jsp"
			
		</script>	
	<%
		
		}
	%>	

</body>
</html>