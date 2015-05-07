<%-- 
    Document   : resultatAll
    Created on : 7 mai 2015, 14:44:52
    Author     : zakaria
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<double[]> l = (List<double[]>) request.getAttribute("liste");
            //System.out.println(l == null);
            Iterator i = l.iterator();
            while (i.hasNext()) {
                double[] temp = (double[]) i.next();
                for (int j = 0; j < temp.length; j++) 
                {
                    out.print( temp[j]+"|");
                }
                out.println("<br>");
            }
        %>
    </body>
</html>
