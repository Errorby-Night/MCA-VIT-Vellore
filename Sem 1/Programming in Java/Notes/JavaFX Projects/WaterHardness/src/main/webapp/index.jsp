<%-- 
    Document   : index
    Created on : 30-Nov-2023, 12:16:46 pm
    Author     : srija
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter the water hardness:</h1>
        <form action="" method="get">
            <input type="number" name="hard">
            <input type="submit" value="Submit">
        </form>
        <%!
           String hardlevel(int h){
               if(h >= 0 && h <= 60)
                return "Soft";
                else if(h > 60 && h <= 120)
                 return "Moderately Hard";
                else if(h > 120 && h <= 180)
                 return "Hard";
                else
                 return "Very Hard";
           } 
        %>
        <%
            String hardParam = request.getParameter("hard");
            int h = (hardParam != null && !hardParam.isEmpty()) ? Integer.parseInt(hardParam) : 0;
            String output = hardlevel(h);
        %>
        <h2> The water hardness level is: <%=output%></h2>
    </body>
</html>
