<%-- 
    Document   : search
    Created on : 30-Nov-2023, 11:48:35 am
    Author     : srijan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <%
            String sub = request.getParameter("sub");  
        %>
        <%!    
    int displayit(String sub) {
        int p = 0;
        int f = 0;
        for (int i = 0; i < sub.length() && p != -1; i = i + p + 1) {
            p = sub.indexOf(',', i);
            if (p == -1) {
                p = sub.length();  // Set to the length of the string to exit the loop
            }
            String word = sub.substring(i, p);
            if (word.equalsIgnoreCase("Core Java") || word.equalsIgnoreCase("Advanced Java")) {
                f = 1;
                break;
            }
        }
        return f;
    }
%>

        <%
            int f = displayit(sub);
            String s="";
            if(f == 1)
                s = "Accepted";
            else
                s = "Rejected";
        %>
        <h1>Output: <%=s%></h1>
    </body>
</html>
